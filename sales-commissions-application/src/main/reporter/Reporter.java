package main.reporter;

import java.io.File;
import main.domain.*;

import java.util.ArrayList;



public abstract class Reporter {
    File reportFile;
    Associate associate;
    String fileExtension;
    
    public void generateReport(File directory, Associate associate ,ArrayList<ArrayList<String>> data) throws Exception {
        this.associate = associate;
        this.reportFile = new File(directory, associate.getName() + "." + fileExtension);
        openFile();
        writeReport(data);
        closeFile();
    };

    protected abstract void openFile() throws Exception;

    protected abstract void writeReport(ArrayList<ArrayList<String>> data) throws Exception;

    protected abstract void closeFile() throws Exception;

    public File getReportFile() {
        return reportFile;
    }

}
