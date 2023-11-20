package main.reporter;

import java.io.File;

import java.util.ArrayList;

public abstract class Reporter {
    
    public abstract File generateReport(File directory, ArrayList<String> tags, ArrayList<String> values) throws Exception;

}
