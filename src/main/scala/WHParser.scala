package wordhoardutils

object WHParser {

  def extractRange(el: scala.xml.Node): String = {
    val startEl = el \ "start"
    val endEl = el \ "end"
    val rangeStr = "("+ startEl(0).attributes("line").text + "-" + startEl(0).attributes("line").text + ")"
    rangeStr
  }


  def extractAttribution(el: scala.xml.Node): String = {
    val seg = el \ "p" \ "seg" \ "hi"
    seg.text
  }

  def parseAnnotation(el: scala.xml.Node) {
    val rangeStr = extractRange(el)
    val attribution = extractAttribution(el)

    rangeStr
  }


}
