import os._

val wd = os.pwd / "resources" / "input"

sealed trait OriginLike[A]:
  def extract(path: String): A

  def clean(pathContents: A): A

case class StringOrigin() extends OriginLike[String]:
  def extract(fileName: String): String =
    val extracted = os.read(wd / fileName)
    extracted

  def clean(pathContents: String): String =
    val cleanedData =
      pathContents
        .toLowerCase
        .replaceAll(";", "")
        .replaceAll(":", "")
    cleanedData

case class IntOrigin() extends OriginLike[List[Int]]:
  def extract(fileName: String): List[Int] =
    val extracted = os.read(wd / fileName)
      .toList
      .map(newLine => newLine.toInt)
    extracted

  def clean(pathContents: List[Int]): List[Int] =
    val cleanedData =
      pathContents.filter(_ > 0)
    cleanedData

