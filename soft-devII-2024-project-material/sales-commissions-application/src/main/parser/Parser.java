package main.parser;

import java.io.*;

import main.domain.*;

/**
 * The Parser class is an abstract class that is used to parse an input file
 * into the application.Given a receipt file, the parser extracts the associate's
 * name and the receipts from the file. Then creates a new associate object
 * and adds it to a new Entry.
 */

public abstract class Parser {
	protected File fileToParse;
	protected Associate associateToParse;

	public Associate parseAssociateFromFile(File file) throws  Exception {
		this.associateToParse = new Associate();
		this.fileToParse = file;
		setAssociateInfo();
		setAssociateReceipts();
		return associateToParse;
	};

	protected abstract void setAssociateInfo() throws Exception;

	protected abstract void setAssociateReceipts() throws Exception;
	
}
