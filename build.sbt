name := "HackerRank"

version := "0.1"

scalaVersion := "2.13.1"

val sttp = "2.0.0-RC5"

libraryDependencies ++= Seq(
  "com.softwaremill.sttp.client" %% "core" % sttp,
  "com.softwaremill.sttp.client" %% "circe" % sttp
)
