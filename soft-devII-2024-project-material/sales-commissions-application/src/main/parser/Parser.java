package main.parser;


import java.io.*;

import main.domain.*;

/**
 * The Parser class is an abstract class that is used to parse an input file
 * into the application.Given a receipt file, the parser extracts the associate's
 * name and the receipts from the file. Then creates a new associate object
 * and adds it to a new Entry.
 */

//TODO: Rework, the parser doesnt need all these fields
public abstract class Parser {

	public abstract Entry parseFileEntry(File file) throws IOException;
	
}
