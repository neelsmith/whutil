# whutil

Utilities for working with freely downloadable data from worrdhoard at http://wordhoard.northwestern.edu/userman/dev-files.html

Currently included:  

- utilities for working with wordhoard data on Iliadic scholia
    1. convert wordhoard XML text to object representation
    2. serialize object representation as XHTML


## Examples of usage

Parse file from Wordhoard as an ordered list of Scholion objects

    val scholia = WHParser.parseSource(<SOURCEFILEURL>)


Write an ordered list of Scholion objects as HTML suitable for reading with the included `whutils.css` stylesheet:


    ScholiaWriter.writeHtml(scholia, "FILENAME")


## Explanation

Wordhead's XML-formatted data consists of a series of `annotation` elements.  For the Iliadic scholia in the WH data set, each annotation is a single scholion.  `start` and `end` elements refer to passages in the text commented on (for Iliadic scholia, the *Iliad*).  A paragraph (`p` element) contains all remaining content.  With the paragraph, a `seg` element with type `marginalia` marks out an attribution of the scholion to a source.  The start/end references and the attribution are pulled out from the entry. The remaining XML is treated as the "contents" of the scholion, although this is not strictly true, since entries regularly include references to the *sigla* of manuscripts where parts of the reconstructed scholia occur, and sometimes include secondary notes as well.
