package main.reporter;

import main.domain.Associate;

public class ReporterFactory {
    public Reporter getReporter(String fileType , Associate associate) {
        switch(fileType) {
            case "text/plain":
                return new TXTReporter(associate);
            case "application/xml":
                return new XMLReporter(associate);
            default:
                return null;
        }
    }
}
