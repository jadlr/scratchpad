import sbt._

object Dependencies {

  private val CatsVersion                   = "2.1.1"
  private val CatsEffectVersion             = "2.1.4"
  private val ZioVersion                    = "1.0.1"
  private val ZioLoggingVersion             = "0.5.0"
  private val ZioInteropCatsVersion         = "2.1.4.0"
  private val CirceVersion                  = "0.13.0"
  private val LogbackVersion                = "1.2.3"
  private val LogstashLogbackEncoderVersion = "6.4"
  private val Http4sVersion                 = "0.21.7"
  private val Specs2Version                 = "4.10.3"

  lazy val runtimeDeps: Seq[ModuleID] = Seq(
    "org.typelevel"        %% "cats-core"               % CatsVersion,
    "org.typelevel"        %% "cats-effect"             % CatsEffectVersion,
    "io.circe"             %% "circe-core"              % CirceVersion,
    "io.circe"             %% "circe-generic"           % CirceVersion,
    "io.circe"             %% "circe-parser"            % CirceVersion,
    "ch.qos.logback"       % "logback-classic"          % LogbackVersion,
    "dev.zio"              %% "zio"                     % ZioVersion,
    "dev.zio"              %% "zio-interop-cats"        % ZioInteropCatsVersion,
    "dev.zio"              %% "zio-logging"             % ZioLoggingVersion,
    "org.http4s"           %% "http4s-dsl"              % Http4sVersion,
    "org.http4s"           %% "http4s-blaze-server"     % Http4sVersion,
    "org.http4s"           %% "http4s-circe"            % Http4sVersion,
    "net.logstash.logback" % "logstash-logback-encoder" % LogstashLogbackEncoderVersion
  )
  lazy val testDeps: Seq[ModuleID] = Seq(
    "org.specs2" %% "specs2-core" % Specs2Version
  ).map(_ % Test)
}
