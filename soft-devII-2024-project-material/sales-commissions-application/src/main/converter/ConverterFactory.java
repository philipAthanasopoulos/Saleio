package main.converter;

public class ConverterFactory {
    public Converter getConverter(String fileType) {
        switch(fileType) {
            case "txt":
                return new TXTConverter();
            case "xml":
                return new XMLConverter();
            case "html":
                return new HTMLConverter();
            default:
                throw new IllegalArgumentException("File type not supported");
        }
    }
}
