lazy val root = project.in(file(".")).aggregate(events, observer, reactive)

lazy val events = project.in(file("SHAPES/events"))

lazy val observer = project.in(file("SHAPES/observer"))

lazy val reactive = project.in(file("SHAPES/reactive"))

name in ThisBuild := "reshapes"

version in ThisBuild := "0.0.0."

scalaVersion in ThisBuild := "2.11.2"
