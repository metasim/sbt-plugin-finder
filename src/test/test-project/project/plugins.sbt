// build root project
lazy val root = Project("plugins", file(".")) dependsOn pluginFinder

// depends on the awesomeOS project
lazy val pluginFinder = file("../../..").getAbsoluteFile.toURI
