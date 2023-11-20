package main.reporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TXTReporter extends Reporter{
    
    @Override
    public File generateReport(File directory, ArrayList<String> tags, ArrayList<String> values ) throws IOException{
        File resultFile = new File(directory, "report.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(resultFile));

        for(String tag : tags){
            bufferedWriter.write(tag + ": " + values.get(tags.indexOf(tag)));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        return resultFile;
    }
}
