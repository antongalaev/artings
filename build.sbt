ThisBuild / scalaVersion := "3.3.1"

ThisBuild / version := "1.0"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """artings""",
    libraryDependencies ++= Seq(
      guice,
      "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.0" % Test
    )
  )

// Config for assembly
assembly / mainClass := Some("play.core.server.ProdServerStart")
assembly / fullClasspath += Attributed.blank(PlayKeys.playPackageAssets.value)

// Merge strategy for assembling conflicts
assembly / assemblyMergeStrategy := {
  case PathList("reference.conf") => MergeStrategy.concat
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case _ => MergeStrategy.first
}
