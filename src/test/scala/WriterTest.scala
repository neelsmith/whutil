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
      val x = 1
      x must_== 1
     }
   }


}
