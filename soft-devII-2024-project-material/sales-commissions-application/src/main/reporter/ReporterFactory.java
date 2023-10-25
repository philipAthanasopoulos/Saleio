package main.reporter;

import main.domain.Associate;

public class ReporterFactory {
    public Reporter getReporter(String fileType , Associate associate) {
        switch(fileType) {
            case "text/plain":
            case"txt":
            case "TXT":
                return new TXTReporter(associate);
            case "application/xml":
            case "xml":
            case "XML":
                return new XMLReporter(associate);
            default:
                return null;
        }
    }
}
