package parser;


import java.io.File;

import domain.Agent;
import domain.Coat;
import domain.Receipt;
import domain.Shirt;
import domain.Skirt;
import domain.Trouser;

public abstract class Parser {
	
	protected Agent agent;
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
		agent = new Agent();
		kind  = new String("");
	}
	

	
	public void addAgent() {
		agent.setName(name);
		agent.setAfm(afm);
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
			receipt.getCompany().setName(companyName);
			receipt.getCompany().getCompanyAddress().setCountry(companyCountry);
			receipt.getCompany().getCompanyAddress().setCity(companyCity);
			receipt.getCompany().getCompanyAddress().setStreet(companyStreet);
			receipt.getCompany().getCompanyAddress().setStreetNumber(companyStreetNumber);
			agent.getReceipts().add(receipt);
	}
	public Agent getAgent() {
		return agent;
	}

	
}
