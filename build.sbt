import Dependencies._

lazy val root = (project in file(".")).settings(
  inThisBuild(
    List(
      organization := "io.trsc",
      scalaVersion := "2.13.5",
      version := "0.1.0-SNAPSHOT",
      scalacOptions ++= ScalacOptions.opts,
      addCompilerPlugin("org.typelevel" % "kind-projector" % "0.11.3" cross CrossVersion.full),
      shellPrompt := Prompt.format
    )
  ),
  name := "scratchpad",
  libraryDependencies ++= runtimeDeps ++ testDeps
)
