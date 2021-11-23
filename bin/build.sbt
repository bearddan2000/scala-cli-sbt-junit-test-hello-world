lazy val root = (project in file("."))
  .settings(

  fork in Test := true,

  testOptions += Tests.Argument(TestFrameworks.JUnit, "--run-listener=example.JUnitListener"),

  // Project name (artifact name in Maven)
  name := "(scala-cli-sbt-junit)",

  // orgnization name (e.g., the package name of the project)
  organization := "example",

  version := "1.0-SNAPSHOT",

  // project description
  description := "Treasure Data Project",

  // Do not append Scala versions to the generated artifacts
  crossPaths := false,

  // This forbids including Scala related libraries into the dependency
  autoScalaLibrary := true,

  libraryDependencies ++= Seq(
    "junit" % "junit" % "4.12",
    "com.novocode" % "junit-interface" % "0.11" % Test
   ),

  mainClass := Some("example.Main")
)
