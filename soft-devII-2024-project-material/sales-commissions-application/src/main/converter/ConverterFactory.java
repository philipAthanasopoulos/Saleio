package main.converter;

import main.domain.Associate;

public class ConverterFactory {
    public Converter getConverter(String fileType , Associate associate) {
        switch(fileType) {
            case "txt":
                return new TXTConverter(associate);
            case "xml":
                return new XMLConverter(associate);
            case "html":
                return new HTMLConverter(associate);
            default:
                throw new IllegalArgumentException("File type not supported");
        }
    }
}
