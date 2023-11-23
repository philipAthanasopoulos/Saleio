package main.reporter;

import java.io.File;
import main.domain.*;

import java.util.ArrayList;



public abstract class Reporter {
    File reportFile;
    Associate associate;
    ArrayList<ProductType> productsToReport;
    String fileExtension;
    
    public void generateReport(File directory, Associate associate, ArrayList<ProductType> productsToReport) throws Exception {
        this.associate = associate;
        this.productsToReport = productsToReport;
        this.reportFile = new File(directory, associate.getName() + "." + fileExtension);
        openFile();
        
    };

}
