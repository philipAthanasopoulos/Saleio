package main.fileAppender;

public class FileAppenderFactory {
    public FileAppender getFileAppender(String fileType) {
        switch(fileType) {
            case "text/plain":
                return new FileAppenderTXT();
            case "appalication/xml":
            case "text/xml":
                return new FileAppenderXML();
            default:
                return null;
        }
    }
}
