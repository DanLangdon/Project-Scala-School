import os._
import pureconfig._
import pureconfig.generic

val wd = os.pwd / "resources" / "configs" / "intType"

case class LoaderType(useInt: Boolean, useString: Boolean)

@main def loader(): Unit =
  val source = ConfigSource.file(wd.toString)
  println("Enter file name (including suffix):")
  val fileName = scala.io.StdIn.readLine()
  val x = source.loadOrThrow[LoaderType]
