package io.trsc.scratchpad

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {
  override def run(args: List[String]): IO[ExitCode] = {
    IO.delay(println("Hello")).map(_ => ExitCode.Success)
  }
}
