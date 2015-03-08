name in ThisBuild := "events"

organization in ThisBuild := "de.tuda.stg"

version in ThisBuild := "0.0.0"

scalaVersion in ThisBuild := "2.11.2"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.0.2",
  "org.scala-lang" % "scala-actors" % "2.10+",
  "org.scala-lang" % "scala-swing" % "2.11+",
  "de.tuda.stg" %% "rescala" % "0+")
