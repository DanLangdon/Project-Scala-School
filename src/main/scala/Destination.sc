import os._

val wd = os.pwd / "resources" / "output"

sealed trait DestinationLike[A]:
  def save(dataToBeSaved: A, prefix: String, suffix: String): Unit

  def transform(toBeTransformed: A): A

case class StringDestination() extends DestinationLike[String]:
  def save(dataToBeSaved: String, prefix: String, suffix: String) =
    os.temp(dataToBeSaved, wd, prefix, suffix, false)

  def transform(toBeTransformed: String): String =
    val grammaticalCapital =
      toBeTransformed
        .split(".")
        .toList
        .map(sentence => sentence.capitalize)
        .toString
    grammaticalCapital

case class IntDestination() extends DestinationLike[List[Int]]:
  def save(dataToBeSaved: List[Int], prefix: String, suffix: String): Unit =
    val dataAsString = dataToBeSaved.map(x => x.toString)
    os.temp(dataAsString, wd, prefix, suffix, false)

  def transform(toBeTransformed: List[Int]): List[Int] =
    val onlyEvenNums = toBeTransformed.map(x => if(x %2 != 0) x - 1 else x)
    onlyEvenNums