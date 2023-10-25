package main.parser;

public class ParserFactory {

    public Parser getParser(String fileType) {
        switch(fileType) {
            case "text/plain":
                return new TXTParser();
            case "application/xml":
                return new XMLParser();
            default:
                return null;
        }
    }
}
