package main.parser;


import java.io.File;

import main.domain.*;
import main.domain.Associate;

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

	public abstract void readFile();

	
	public Parser() {
		associate = new Associate();
		kind  = new String("");
	}
	

	
	public void addAgent() {
		associate.setName(name);
		associate.setAfm(afm);
	}
	
	public void addReceipt( ){
		Receipt receipt;			
		if(kind.equals("Shirts")) {
			receipt= new Shirt();

		}
		else if (kind.equals("Skirts")) {
			receipt = new Skirt();

		}
		else if (kind.equals("Trousers")) {
			receipt = new Trouser();

		}
		else {
			receipt = new Coat();
		}

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
