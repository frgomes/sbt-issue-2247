import sbt._
import Keys._

lazy val buildSettings: Seq[Setting[_]] = Defaults.defaultSettings

lazy val forkRunOptions: Seq[Setting[_]] = Seq(fork := true)


addCommandAlias("r1",       "ModuleA/RunnerR1:run")
addCommandAlias("r2",       "ModuleA/RunnerR2:run")


lazy val RunnerR1 = sbt.config("RunnerR1").extend(Compile)
lazy val RunnerR2 = sbt.config("RunnerR2").extend(Compile)


lazy val root =
  project
    .in(file("."))
    .settings(buildSettings:_*)
    .aggregate(ModuleA)

lazy val ModuleA =
  project
    .in(file("ModuleA"))
    .settings(buildSettings:_*)
    .configs(RunnerR1,RunnerR2)
    .settings(inConfig(RunnerR1)(
      forkRunOptions ++
        Seq(
          mainClass in Compile :=  Option("sbt.tests.issueX.Application1"))):_*)
    .settings(inConfig(RunnerR2)(
      forkRunOptions ++
        Seq(
          mainClass in Compile :=  Option("sbt.tests.issueX.Application2"))):_*)
