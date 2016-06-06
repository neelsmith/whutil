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
