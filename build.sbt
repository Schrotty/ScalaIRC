name := "ScalaIRC"

version := "0.1"

scalaVersion := "2.13.0"

assemblyJarName in assembly := "scalaIRC.jar"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.23"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.23"
