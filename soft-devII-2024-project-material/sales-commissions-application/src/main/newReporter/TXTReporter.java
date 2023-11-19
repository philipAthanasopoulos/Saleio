package main.newReporter;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;

public class TXTReporter extends Reporter{
    
    @Override
    public void createAndSaveReport(File directory, ArrayList<String> tags, ArrayList<String> values ) throws Exception{
        File reportFile = new File(directory, "report.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(reportFile));

        for(String tag : tags){
            bufferedWriter.write(tag + ": " + values.get(tags.indexOf(tag)));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
