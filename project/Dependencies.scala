import sbt._

object Dependencies {

  private val CatsVersion       = "1.5.0"
  private val CatsEffectVersion = "1.1.0"
  private val CirceVersion      = "0.10.1"
  private val LogbackVersion    = "1.2.3"

  lazy val runtimeDeps: Seq[ModuleID] = Seq(
    "org.typelevel"         %% "cats-core"              % CatsVersion,
    "org.typelevel"         %% "cats-effect"            % CatsEffectVersion,
    "io.circe"              %% "circe-core"             % CirceVersion,
    "io.circe"              %% "circe-generic"          % CirceVersion,
    "io.circe"              %% "circe-parser"           % CirceVersion,
    "ch.qos.logback"        %  "logback-classic"        % LogbackVersion
  )

  lazy val testDeps: Seq[ModuleID] = Seq(
    "org.specs2" %% "specs2-core" % "4.3.5"
  ).map(_ % Test)

}
