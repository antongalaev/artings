lazy val root = (project in file("."))
  .enablePlugins(PlayScala, UniversalPlugin)
  .settings(
    name := """artings""",
    version := "2.0",
    maintainer := "wgalaev@gmail.com",
    scalaVersion := "3.5.1",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test
    )
  )