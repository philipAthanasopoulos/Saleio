package main.reporter;

import main.domain.Associate;

public class ReporterFactory {
    public Reporter getReporter(String fileType , Associate associate) {
        switch(fileType) {
            case "txt":
                return new TXTReporter(associate);
            case "xml":
                return new XMLReporter(associate);
            default:
                throw new IllegalArgumentException("File type not supported");
        }
    }
}
