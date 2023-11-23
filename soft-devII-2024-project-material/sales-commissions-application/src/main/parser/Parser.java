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

	public Associate parseAssociateFromFile(File file) throws  Exception {
		Associate resultAssociate = new Associate();
        setAssociateInfo(file, resultAssociate);
        setAssociateReceipts(file, resultAssociate);
        return resultAssociate;
	};

	protected abstract void setAssociateInfo(File file, Associate resultAssociate) throws Exception;

	protected abstract void setAssociateReceipts(File file, Associate resultAssociate) throws Exception;
	
}
