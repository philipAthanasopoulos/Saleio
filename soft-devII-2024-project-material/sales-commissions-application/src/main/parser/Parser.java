package main.parser;


import java.io.File;
import java.io.IOException;

import main.domain.*;
import main.domain.Associate;

//TODO: Rework, the parser doesnt need all these fields
public abstract class Parser {
	protected Associate associate;
	protected File inputFile;
	protected String inputFilePath;
	protected String name;
	protected String afm;
	protected int receiptID;
	protected String date;
	protected String kind;
	protected double sales;
	protected int items;
	protected String companyName;
	protected String companyCountry;
	protected String companyCity;
	protected String companyStreet;
	protected int companyStreetNumber;

	public abstract void readFile() throws IOException;

	
	public Parser() {
		associate = new Associate();
		kind  = new String("");
	}
	
	public void addAgent() {
		associate.setName(name);
		associate.setAfm(afm);
	}
	
	public void addReceipt(){
		Receipt receipt = new Receipt();
		receipt.setReceiptID(receiptID);
		receipt.setDate(date);
		receipt.setSales(sales);
		receipt.setItems(items);
		receipt.getCompany().setCompanyName(companyName);
		receipt.getCompany().getCompanyAddress().setCountry(companyCountry);
		receipt.getCompany().getCompanyAddress().setCity(companyCity);
		receipt.getCompany().getCompanyAddress().setStreet(companyStreet);
		receipt.getCompany().getCompanyAddress().setStreetNumber(companyStreetNumber);
		associate.getReceipts().add(receipt);
	}
	public Associate getAgent() {
		return associate;
	}
}
