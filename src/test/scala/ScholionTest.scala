package wordhoardutils

import org.specs2.mutable._
import scala.io.Source
import java.io.File
import java.io.PrintWriter
//import scala.xml


class  ScholionTest extends Specification {

  "A Scholion object" should {
    "format appropriate HTML" in {
      val rangeStr = "5.1-5.1"
      val attribution = "ex."
      val xmlContent = <p><span class="bold">1</span> a. <span class="sperrtext">ἔνθ' αὖ</span> τότε, ὅτε καὶ πολλοὶ ἀπώλλοντο. <span class="bold">A</span><span class="superscript">int</span> b (bce<span class="superscript">3</span> e<span class="superscript">4</span>)<span class="bold">T</span></p>

      val schol = new Scholion(rangeStr, attribution, xmlContent)
      val xmlFormatted = schol.toXmlStr()

      xmlFormatted must have size(448)



    }
   }


   



}
