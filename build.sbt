
import pl.project13.scala.sbt.JmhPlugin

version := "1.0"

name := "perftest"

scalaVersion in ThisBuild := "2.11.8"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.2" % "test"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

enablePlugins(JmhPlugin)
