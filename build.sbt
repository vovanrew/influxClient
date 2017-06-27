name := "influxClient"

version := "1.0"

scalaVersion := "2.12.1"


libraryDependencies ++= Seq(
  "org.apache.kafka" % "kafka-clients" % "0.10.2.1",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.8.2",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.6",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.6",
  "com.paulgoldbaum" %% "scala-influxdb-client" % "0.5.2",
  "com.typesafe" % "config" % "1.3.1"
)