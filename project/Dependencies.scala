import sbt._

object Dependencies {

  private val CatsVersion       = "2.0.0"
  private val CatsEffectVersion = "2.0.0"
  private val CirceVersion      = "0.12.1"
  private val LogbackVersion    = "1.2.3"
  private val Specs2Version     = "4.7.1"


  lazy val runtimeDeps: Seq[ModuleID] = Seq(
    "org.typelevel"         %% "cats-core"              % CatsVersion,
    "org.typelevel"         %% "cats-effect"            % CatsEffectVersion,
    "io.circe"              %% "circe-core"             % CirceVersion,
    "io.circe"              %% "circe-generic"          % CirceVersion,
    "io.circe"              %% "circe-parser"           % CirceVersion,
    "ch.qos.logback"        %  "logback-classic"        % LogbackVersion
  )

  lazy val testDeps: Seq[ModuleID] = Seq(
    "org.specs2" %% "specs2-core" % Specs2Version
  ).map(_ % Test)

}
