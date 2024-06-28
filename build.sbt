val scala3Version = "3.4.1"

lazy val root = project
  .in(file("."))
  .settings(
    name := "998-dans-project",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "0.7.29" % Test,
      "org.scala-lang" %% "toolkit" % "0.2.1",
      "com.github.pureconfig" %% "pureconfig-core" % "0.17.6"
    )
  )


