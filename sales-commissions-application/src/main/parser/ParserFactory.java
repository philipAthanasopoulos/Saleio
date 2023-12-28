package main.parser;

public class ParserFactory {

    public Parser getParser(String fileType) {
        switch(fileType) {
            case "txt":
                return new TXTParser();
            case "xml":
                return new XMLParser();
            case "html":
                return new HTMLParser();
            default:
                throw new IllegalArgumentException("File type not supported");
        }
    }
}
