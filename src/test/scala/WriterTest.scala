package wordhoardutils

import org.specs2.mutable._
import scala.io.Source
import java.io.File
import java.net.URL
import java.io.PrintWriter


class  WriterTest extends Specification {

  "A ScholiaWriter" should {
    "write HTML for an array of scholia" in {
      val f = "src/test/resources/testoutput.html"
      val scholiaUrl = getClass.getResource("/iliad-scholia-test.xml")
      val scholia = WHParser.parseSource(scholiaUrl)
      ScholiaWriter.writeHtml(scholia, f)
      // parse html output and test that it has same
      // number of scholia as Wordhoard source
      val outFile = new File(f)
      val root = scala.xml.XML.loadFile(outFile)
      val htmlScholia = root \ "body" \  "div"
      htmlScholia must have size(745)
     }
   }


}
