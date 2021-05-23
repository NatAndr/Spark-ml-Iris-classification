name := "iris-classification"

version := "0.1"

scalaVersion := "2.12.6"

lazy val sparkVersion = "3.1.1"
lazy val kafkaVersion = "2.8.0"

libraryDependencies ++= Seq(
  "com.typesafe"      % "config"      % "1.4.0",
  "org.apache.spark" %% "spark-sql"   % sparkVersion % "provided",
  "org.apache.spark" %% "spark-mllib" % sparkVersion % "provided"
)

assemblyMergeStrategy in assembly := {
  case m if m.toLowerCase.endsWith("manifest.mf")       => MergeStrategy.discard
  case m if m.toLowerCase.matches("meta-inf.*\\.sf$")   => MergeStrategy.discard
  case "reference.conf"                                 => MergeStrategy.concat
  case x: String if x.contains("UnusedStubClass.class") => MergeStrategy.first
  case _                                                => MergeStrategy.first
}
