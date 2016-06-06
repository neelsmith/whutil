package wordhoardutils

class Scholion (  val rangeString: String,  val attrib: String,  val xmlContent: scala.xml.Node) {

  // HTML format used by HMT project a decade ago.
  def toXmlStr(): String = {
    val xmlComposite = <div>{rangeString}<div class="entry"><div class="attribution"><p><span class="marginalia"><span class="italic">{attrib}</span></span></p></div><div class="content">{xmlContent}</div></div></div>

    xmlComposite.toString()
  }


}
