package main.newReporter;

import java.io.File;
import java.util.ArrayList;

public abstract class Reporter {

    public abstract void createAndSaveReport(File directory, ArrayList<String> tags, ArrayList<String> values ) throws Exception;
    
}
