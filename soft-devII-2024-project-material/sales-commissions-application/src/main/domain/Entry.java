package main.domain;
import main.fileAppender.FileAppender;
import main.fileAppender.FileAppenderTXT;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 * @author Philip Athanasopoulos
 * The Entry class represents a single entry in the GUI application.
 * When the user enters a file, a new entry is created.
 * The entry consists of an associate and the file containing their receipts.
 */

/*TODO:
 * When a new entry is created, a parser should be called to extract 
 * the associate's name and the receipts from the file. Then create a new
 * associate object and add it to the entry.
 */
public class Entry {
    private Associate associate;
    private File receiptsFile;
    private FileAppender fileAppender;

    public Entry(File receiptsFile, Associate associate) {
        this.receiptsFile = receiptsFile;
        this.associate = associate;
        this.fileAppender = new FileAppenderTXT();
    }

    public void addReceipt(Receipt receipt) {
        associate.addReceipt(receipt);
        fileAppender.appendReceipt(receipt,receiptsFile);
    }

    public String getFileAsString() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(receiptsFile));
            String result = "";
            String line;
            while((line = bufferedReader.readLine()) != null) {
                result += line + "\n";
            }
            return result;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    public Associate getAssociate() {
        return this.associate;
    }

    public void setAssociate(Associate associate) {
        this.associate = associate;
    }

    public File getReceiptsFile() {
        return this.receiptsFile;
    }
    
    public void setReceiptsFile(File receiptsFile) {
        this.receiptsFile = receiptsFile;
    }
    
    public FileAppender getFileAppender() {
        return this.fileAppender;
    }
    
    public void setFileAppender(FileAppender fileAppender) {
        this.fileAppender = fileAppender;
    }

    public String getFileType() {
        return this.receiptsFile.getName().substring(this.receiptsFile.getName().lastIndexOf(".")+1).toLowerCase();
    }
}
