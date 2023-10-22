package main.parser;


import main.domain.Associate;
import main.domain.Entry;

import java.util.ArrayList;

import java.io.File;
import java.io.IOException;

public class XMLParser extends Parser {
 
    @Override
    public Entry parseFileEntry(File file) throws IOException {
        return null;
    }

    @Override
    public  Associate extractAssociate(ArrayList<String> fileContent){
        return null;
    }

    @Override
	public ArrayList<String> extractFileContent(File file){
        return null;
    }

	
}


