
sbtPlugin := true

name := "sbt-plugin-finder"

organization := "net.metasim"

licenses += "MIT License" -> url("http://www.opensource.org/licenses/mit-license.php")

scalaVersion := "2.10.6"

scalaVersion in Global := "2.10.6"

scalacOptions ++= Seq("-deprecation", "-unchecked")


libraryDependencies ++= Seq(
  "net.caoticode.buhtig" %% "buhtig" % "0.3.1",
  "org.json4s" %% "json4s-native" % "3.2.10" force(),
  "org.slf4j" % "slf4j-api" % "1.7.12",
  "ch.qos.logback" % "logback-classic" % "1.1.3"
)

scriptedSettings

scriptedLaunchOpts += "-Dproject.version=" + version.value

// scriptedBufferLog := false
