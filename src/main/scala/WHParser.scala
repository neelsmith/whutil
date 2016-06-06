package wordhoardutils

import scala.xml.transform._
import scala.io.Source
import java.io.File
import java.net.URL
import scala.collection.mutable.ArrayBuffer

object WHParser {


  val extractScholionContent = new RewriteRule {
    override def transform(n: scala.xml.Node) = n match {
      case e if (e \ "@type").text == "marginalia" => scala.xml.NodeSeq.Empty
      case  _ => n
    }
  }

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


  def parseAnnotation(el: scala.xml.Node): Scholion = {
    val rge = extractRange(el)
    val attribution = extractAttribution(el)
    val commentary = new RuleTransformer(extractScholionContent).transform(el \ "p")
    val s = new Scholion(rge, attribution, commentary(0))
    s
  }


  def parseSource(src: URL): Array[Scholion] = {
    val scholia =  ArrayBuffer[Scholion]()



    val root = scala.xml.XML.load(src)
    for (s <- root \ "annotation") {
      scholia += parseAnnotation(s)
    }

    scholia.toArray[Scholion]

  }

}
