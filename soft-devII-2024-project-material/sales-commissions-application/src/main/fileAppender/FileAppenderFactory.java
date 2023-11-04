package main.fileAppender;

public class FileAppenderFactory {
    public FileAppender getFileAppender(String fileType) {
        switch(fileType) {
            case "txt":
                return new FileAppenderTXT();
            case "xml":
                return new FileAppenderXML();
            default:
                throw new IllegalArgumentException("File type not supported");
        }
    }
}
