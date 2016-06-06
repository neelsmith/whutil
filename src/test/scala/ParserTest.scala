package wordhoardutils

import org.specs2.mutable._
import scala.io.Source
import java.io.File
import java.net.URL
import java.io.PrintWriter



class  ParserTest extends Specification {

  "A WHParser object" should {
    "construct a Scholion from a wordhoard annotation" in {

    val el = <annotation><start line="IL.17.1"/><end line="IL.17.2"/><p><hi rend="bold">1-2</hi> a.<hi rend="superscript">1</hi>  &lt;<hi rend="sperrtext">οὐδ' ἔλαθ' Ἀτρέος υἱὸν</hi><hi rend="monospaced"> —————— </hi><hi rend="sperrtext">ἐν δηϊοτῆτι:</hi>&gt; εὖ Πατρόκλου πεσόντος πρῶτος αἰσθάνεται Μενέλαος· φησὶ γάρ· „ὃς κεῖται ἐμῆς †εἵνεκ'† ἐνθάδε τιμῆς“ (Ρ 92). καὶ ὅτι ὁμότροποι· ἄμφω γὰρ ἤπιοι· <hi rend="bold">B</hi>(bce<hi rend="superscript">3</hi>e<hi rend="superscript">4</hi>)<hi rend="bold">T</hi> „νῦν τις ἐνηείης Πατροκλῆος δειλοῖο / μνησάσθω“ (Ρ 670-1). <hi rend="bold">T</hi> ὁ δὲ Μενέλαος οὐ μόνον πρὸς τοὺς ἀρχομένους πρᾷος ἦν, ἀλλ' ἤδη καὶ πρὸς τοὺς πολεμίους, <hi rend="bold">B</hi>(bce<hi rend="superscript">3</hi>e<hi rend="superscript">4</hi>)<hi rend="bold">T</hi> ὥστε Ἄδραστον ζωγρήσας σώζειν ἐβούλετο (cf. Ζ 37-53). <hi rend="bold">T</hi> ἢ ὅτι καὶ περὶ πάντας σπουδαῖος ὁρᾶται· <hi rend="bold">B</hi>(bce<hi rend="superscript">3</hi>e<hi rend="superscript">4</hi>)<hi rend="bold">T</hi> αὐτόματος ᾔει πρὸς τὴν δαῖτα (cf. Β 408-9), <hi rend="bold">T</hi> προανέστη τοῦ ἀδελφοῦ (cf. Κ 25-33), Ὀδυσσέως καταπονουμένου ἧκεν ἄγων Αἴαντα (cf. Λ 463-88), <hi rend="bold">B</hi>(bce<hi rend="superscript">3</hi>e<hi rend="superscript">4</hi>)<hi rend="bold">T</hi> ἔμεινεν ἐν τῷ Σουνίῳ „ἐπειγόμενός περ ὁδοῖο, / ὄφρ' ἕταρον θάπτοι“ (γ 284-5). <hi rend="bold">T</hi> ἢ προθυμότερον ποιῶν ἑαυτῷ σύμμαχον Ἀχιλλέα. ἄλλως τε οἱ ἄλλοι τραυματίαι εἰσὶ πλὴν Αἴαντος, ὃν νῦν οὐκ ἔδει ὑπείκειν Ἕκτορι. <hi rend="bold">B</hi>(bce<hi rend="superscript">3</hi>e<hi rend="superscript">4</hi>)<hi rend="bold">T</hi><seg type="marginalia"><hi rend="italic">ex.</hi></seg></p></annotation>

    val s = WHParser.parseAnnotation(el)

    val rg = WHParser.extractRange(el)
    rg must_== "(IL.17.1-IL.17.1)"

    val att = WHParser.extractAttribution(el)
    att must_== "ex."
    }
   }

   "A WHParser object" should {
     "build a list of Scholion objects from a wordhoard file IDed by URL" in {
       val fileUrl = getClass.getResource("/iliad-scholia-test.xml")
       val scholia = WHParser.parseSource(fileUrl)
       scholia must have size(745)
     }
   }

    "A WHParser object" should {
      "build a list of Scholion objects from a wordhoard file as a File object" in {
          val f = new File("src/test/resources/iliad-scholia-test.xml")
          val scholia = WHParser.parseFile(f)
          scholia must have size(745)
        }
      }
}
