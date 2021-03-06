organization  := "eu.route20"

name := "doyle"

version := "1.0"

scalaVersion := "2.10.3"

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= {
  val akkaV = "2.1.4"
  val sprayV = "1.1-RC2"
  Seq(
    "io.spray"            %   "spray-can"     % sprayV,
    "io.spray"            %   "spray-routing" % sprayV,
    "io.spray"            %   "spray-testkit" % sprayV,
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV,
	"org.scalatest" % "scalatest_2.10" % "2.0" % "test",
	"org.scalamock" %% "scalamock-scalatest-support" % "3.1.RC1" % "test"  )
}

//seq(Revolver.settings: _*)

