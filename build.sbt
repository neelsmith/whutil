lazy val root = (project in file(".")).
  settings(
    name := "wordhoardutils",
    version := "1.0",
    scalaVersion := "2.11.7"
  )

libraryDependencies += "org.specs2" %% "specs2-core" % "3.0" % "test"
libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.5"
resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

scalacOptions in Test ++= Seq("-Yrangepos")
