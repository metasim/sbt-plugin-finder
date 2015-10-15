
sbtPlugin := true

name := "sbt-plugin-finder"

organization := "net.metasim"

licenses += "MIT License" -> url("http://www.opensource.org/licenses/mit-license.php")

scalaVersion := "2.10.6"

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= Seq(
  "org.apache.httpcomponents" % "fluent-hc" % "4.5",
  "org.json4s" %% "json4s-native" % "3.2.11"
)

scriptedSettings

scriptedLaunchOpts += "-Dproject.version=" + version.value

// scriptedBufferLog := false
