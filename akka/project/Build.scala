/*
 * Copyright 2013 Katarzyna Szawan <kat.szwn@gmail.com>
 *     and Michał Rus <https://michalrus.com/>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import sbt._
import Keys._

import sbtassembly.Plugin._
import AssemblyKeys._

object Build extends Build {

  // --- root

  lazy val root = Project(id = "root", base = file(".")).settings(
    assemblySettings ++ Seq(

      name := "agh-mindmapd",
      version := "1.0",
      scalaVersion := "2.10.3",

      javacOptions in Compile ++= Seq("-Xlint:deprecation"),
      scalacOptions in Compile ++= Seq("-feature", "-deprecation", "-Yno-adapted-args", "-Ywarn-all", "-Xfatal-warnings",
        "-Xlint", "-Ywarn-value-discard", "-Ywarn-numeric-widen", "-Ywarn-dead-code", "-unchecked"),

      resolvers += "michalrus.com repo" at "https://maven.michalrus.com/",
      addCompilerPlugin("org.brianmckenna" % "wartremover" % "0.6-SNAPSHOT" cross CrossVersion.full),
      scalacOptions += "-P:wartremover:traverser:org.brianmckenna.wartremover.warts.Unsafe",

      resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
      libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.2.3",

      resolvers += "spray repo" at "http://repo.spray.io",
      libraryDependencies += "io.spray" % "spray-can" % "1.2.0",
      libraryDependencies += "io.spray" % "spray-routing" % "1.2.0",
      libraryDependencies += "io.spray" %% "spray-json" % "1.2.5",

      libraryDependencies += "org.squeryl" %% "squeryl" % "0.9.5-6",
      libraryDependencies += "postgresql" % "postgresql" % "8.4-701.jdbc4"

    ): _*)

}
