import Dependencies._

lazy val root = (project in file(".")).settings(
  inThisBuild(
    List(
      organization := "io.trsc",
      scalaVersion := "2.12.10",
      version := "0.1.0-SNAPSHOT",
      scalacOptions ++= ScalacOptions.opts,
      scalacOptions in (Compile, console) --= ScalacOptions.excludeInConsoleAndCompile,
      addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3"),
      shellPrompt := Prompt.format
    )
  ),
  name := "scratchpad",
  libraryDependencies ++= runtimeDeps ++ testDeps
)
