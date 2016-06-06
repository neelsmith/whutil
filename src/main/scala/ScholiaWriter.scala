package wordhoardutils

import scala.xml.transform._
import scala.io.Source
import java.io.File
import java.net.URL
import scala.collection.mutable.ArrayBuffer
import java.io.PrintWriter

object ScholiaWriter {

val topStr = """<html>
  	<head>
  	<title>Wordhoard text of scholia</title>
  	<link rel="stylesheet" href="whutil.css"/>
  	</head>
  	<body>
"""

val tailStr = "</body></html>"

  def writeHtml(scholia: Array[Scholion], fName: String)  {
    val outWriter = new PrintWriter(fName)
    outWriter.println(topStr)
    for (s <- scholia) {
      outWriter.println(s.toXmlStr)
    }
    outWriter.println(tailStr)
  }

}
