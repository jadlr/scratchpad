package io.trsc.scratchpad


import java.io.File
import java.nio.ByteBuffer
import java.util.UUID

import cats.implicits._
import cats.data.EitherT

import scala.collection.JavaConverters._
import com.softwaremill.sttp._
import com.softwaremill.sttp.okhttp.monix.OkHttpMonixBackend
import monix.eval._
import monix.execution.Scheduler.Implicits.global
import monix.reactive._
import org.jsoup.Jsoup

import scala.concurrent.Await
import scala.concurrent.duration._


object Main extends App {
  implicit val backend: SttpBackend[Task, Observable[ByteBuffer]] = OkHttpMonixBackend()

  def site(page: Int): String = s"https://tineye.com/search/61972c67ed77b8eb39f71e7e04cb1153e51db981/?page=$page&sort=score&order=desc"

  val tasks = 1 to 300 map { p ⇒
    EitherT(loadPage(site(p))).flatMapF { urls ⇒
      Task.gatherUnordered(urls.map(download)).map(_.asRight)
    }.value
  }

  // This was too aggressive
  //  val batches = tasks.sliding(5,5).map(b => Task.gatherUnordered(b))
  val aggregate = Task.sequence(tasks)

  Await.result(aggregate.runAsync, Duration.Inf)

  def loadPage(url: String): Task[Either[String, List[String]]] =
    sttp
      .readTimeout(1 minute)
      .get(uri"$url")
      .send()
      .map(_.body.map { body ⇒
        val parsed = Jsoup.parse(body)
        val elements = parsed.select(".image-link a")
        elements.asScala.map(_.attr("href")).toList
      })


  def download(url: String): Task[Response[File]] = {
    val ending =
      if (url.contains("jpg")) ".jpg"
      else if (url.contains("jpeg")) ".jpeg"
      else if (url.contains("png")) ".png"
      else ".unknown"
    sttp
      .readTimeout(25 seconds)
      .response(asFile(new File("download/" + UUID.randomUUID().toString + ending), overwrite = true))
      .get(uri"$url").send()
  }
}
