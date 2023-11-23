package main.reporter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TXTReporter extends Reporter{
    
    BufferedWriter writer;

    public TXTReporter() {
        this.fileExtension = "txt";
    }

    @Override
    protected void openFile() throws IOException {
        writer = new BufferedWriter(new java.io.FileWriter(reportFile));
    }

    @Override
    protected void writeReport(ArrayList<ArrayList<String>> data) throws IOException {
        for (ArrayList<String> row : data) {
            for (String cell : row) {
                writer.write(cell);
                writer.write(":");
                writer.write("\t");
            }
            writer.newLine();
        }
    }

    @Override
    protected void closeFile() throws IOException {
        writer.close();
    }
}
