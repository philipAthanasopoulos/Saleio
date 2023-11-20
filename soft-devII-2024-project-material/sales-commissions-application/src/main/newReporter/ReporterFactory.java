package main.newReporter;

public class ReporterFactory {
    public Reporter getReporter(String fileType) {
        switch(fileType) {
            case "txt":
                return new TXTReporter();
            case "xml":
                return new XMLReporter();
            case "html":
                return new HTMLReporter();
            default:
                throw new IllegalArgumentException("File type not supported");
        }
    }
}
