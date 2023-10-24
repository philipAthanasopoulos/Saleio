package main.parser;

public class ParserFactory {

    public static Parser getParser(String fileType) {
        switch(fileType) {
            case "txt":
                return new TXTParser();
            case "xml":
                return new XMLParser();
            default:
                return null;
        }
    }
}
