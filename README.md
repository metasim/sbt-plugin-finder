# sbt-plugin-finder
Find sbt plugins on github.

## Usage

Requires sbt >= 0.13.8

Add this to `project/plugins.sbt`:

    lazy val root = Project("plugins", file(".")) dependsOn pluginFinder
    lazy val pluginFinder = url("https://github.com/metasim/sbt-plugin-finder.git")
    
then in the sbt console run:
     
    showGithubPlugins
    
    
The resulting output will be something like this:
    
    
-------------------------------------    


### Plugin Report

Found 54 plugins under user/organization 'sbt'

* [ant4sbt](https://github.com/sbt/ant4sbt) SBT plug-in to call Ant targets from within SBT builds
* [cpd4sbt](https://github.com/sbt/cpd4sbt) Integrating PMD's Copy/Paste Detector into SBT as a plug-in.
* [findbugs4sbt](https://github.com/sbt/findbugs4sbt) An SBT plug-in that adds a "findbugs" task to SBT for static code analysis of Java code via the great "FindBugs" tool.
* [jacoco4sbt](https://github.com/sbt/jacoco4sbt) JaCoCo Code Coverage plug-in for sbt.
* [sbt-appbundle](https://github.com/sbt/sbt-appbundle) A plugin for the simple-build-tool to create an OS X application bundle.
* [sbt-appengine](https://github.com/sbt/sbt-appengine) deploy your webapp to appengine using sbt.
* [sbt-aspectj](https://github.com/sbt/sbt-aspectj) AspectJ sbt plugin
* [sbt-assembly](https://github.com/sbt/sbt-assembly) Deploy fat JARs. Restart processes. (port of codahale/assembly-sbt)
* [sbt-bintray-bundle](https://github.com/sbt/sbt-bintray-bundle) 
* [sbt-boilerplate](https://github.com/sbt/sbt-boilerplate) sbt plugin for generating scala.Tuple/Function related boilerplate code
* [sbt-buildinfo](https://github.com/sbt/sbt-buildinfo) I know this because build.sbt knows this.
* [sbt-coffeescript](https://github.com/sbt/sbt-coffeescript) A CoffeeScript plugin for SBT
* [sbt-conductr](https://github.com/sbt/sbt-conductr) Typesafe ConductR plugin for sbt
* [sbt-core-next](https://github.com/sbt/sbt-core-next) sbt APIs targeted for eventual inclusion in sbt core
* [sbt-cotest](https://github.com/sbt/sbt-cotest) Cross-project coordinated testing
* [sbt-datatype](https://github.com/sbt/sbt-datatype) 
* [sbt-digest](https://github.com/sbt/sbt-digest) sbt-web plugin for checksum files
* [sbt-dirty-money](https://github.com/sbt/sbt-dirty-money) clean Ivy2 cache
* [sbt-doge](https://github.com/sbt/sbt-doge) sbt plugin to aggregate tasks across subprojects and their crossScalaVersions
* [sbt-duplicates-finder](https://github.com/sbt/sbt-duplicates-finder) Find classes and resources conflicts in your build
* [sbt-fmpp](https://github.com/sbt/sbt-fmpp) FreeMarker Scala/Java Templating Plugin for SBT
* [sbt-ghpages](https://github.com/sbt/sbt-ghpages) git, site and ghpages support for XSBT projects.
* [sbt-git](https://github.com/sbt/sbt-git) A git plugin for SBT
* [sbt-groll](https://github.com/sbt/sbt-groll) sbt plugin to roll the Git history
* [sbt-gzip](https://github.com/sbt/sbt-gzip) sbt-web plugin for gzipping assets
* [sbt-header](https://github.com/sbt/sbt-header) sbt-header is an sbt plugin for creating file headers, e.g. copyright headers
* [sbt-houserules](https://github.com/sbt/sbt-houserules) House rules for sbt modules.
* [sbt-javaversioncheck](https://github.com/sbt/sbt-javaversioncheck) sbt plugin to check Java version
* [sbt-jshint](https://github.com/sbt/sbt-jshint) Allows jslint to be used from within sbt. Builds on com.typesafe:webdriver in order to execute jslint.js along with the scripts to verify
* [sbt-license-report](https://github.com/sbt/sbt-license-report) Report on licenses used in an sbt project.
* [sbt-man](https://github.com/sbt/sbt-man) Looks up scaladoc.
* [sbt-mocha](https://github.com/sbt/sbt-mocha) SBT plugin for running mocha JavaScript unit tests on node
* [sbt-native-packager](https://github.com/sbt/sbt-native-packager) SBT Native Packager
* [sbt-osgi](https://github.com/sbt/sbt-osgi) sbt plugin for creating OSGi bundles
* [sbt-pamflet](https://github.com/sbt/sbt-pamflet) sbt plugin to run Pamflet (and Pamflet plugin to run sbt)
* [sbt-pgp](https://github.com/sbt/sbt-pgp) PGP plugin for SBT 0.12+
* [sbt-pom-reader](https://github.com/sbt/sbt-pom-reader) Translates xml -> awesome.  Maven-ish support for sbt.
* [sbt-proguard](https://github.com/sbt/sbt-proguard) Proguard sbt plugin
* [sbt-properties](https://github.com/sbt/sbt-properties) sbt plugin to read properties from a file and make them available as a map
* [sbt-protobuf](https://github.com/sbt/sbt-protobuf) sbt 0.12/0.13 plugin for compiling protobuf files
* [sbt-release](https://github.com/sbt/sbt-release) A release plugin for sbt (>= 0.11.0)
* [sbt-rjs](https://github.com/sbt/sbt-rjs) RequireJs optimizer plugin for sbt-web
* [sbt-s3](https://github.com/sbt/sbt-s3) sbt-s3 is a simple sbt plugin to manipulate objects on Amazon S3
* [sbt-scalabuff](https://github.com/sbt/sbt-scalabuff) SBT plugin which generate case classes and support for serialization from Google Protocol Buffer definitions using ScalaBuff
* [sbt-scalariform](https://github.com/sbt/sbt-scalariform) sbt plugin adding support for source code formatting using Scalariform
* [sbt-scalashim](https://github.com/sbt/sbt-scalashim) generates sys.error.
* [sbt-sequential](https://github.com/sbt/sbt-sequential) adds sequential tasks to sbt
* [sbt-site](https://github.com/sbt/sbt-site) Site generation for SBT
* [sbt-unidoc](https://github.com/sbt/sbt-unidoc) sbt plugin to create a unified API document across projects
* [sbt-unique-version](https://github.com/sbt/sbt-unique-version) emulates Maven's uniqueVersion snapshots
* [sbt-webdriver](https://github.com/sbt/sbt-webdriver) 
* [sbt-xjc](https://github.com/sbt/sbt-xjc) SBT plugin to compile an XML Schema with XJC
* [sbt-ynolub](https://github.com/sbt/sbt-ynolub) 
    
