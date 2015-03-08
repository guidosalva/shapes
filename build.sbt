lazy val root = project.in(file(".")).aggregate(events, observer, reactive)

lazy val events = project.in(file("events"))

lazy val observer = project.in(file("observer"))

lazy val reactive = project.in(file("reactive"))

name in ThisBuild := "reshapes"

version in ThisBuild := "0.0.0."

scalaVersion in ThisBuild := "2.11.2"
