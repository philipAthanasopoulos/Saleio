package main.domain;


import main.fileAppender.FileAppender;
import main.fileAppender.FileAppenderTXT;
import main.fileAppender.FileAppenderXML;

import java.util.ArrayList;
import java.util.List;

public class Associate {
	private String name;
	private String afm;
	private List<Receipt> receipts;

	public Associate(){
		receipts = new ArrayList<>();
	}

	public double calculateTotalSales(){
		double sumSales = 0;
		for(Receipt receipt : receipts) sumSales += receipt.getTotalSales();
		return sumSales;
	}

	public int calculateTotalItems(){
		int sumItems = 0;
		for(Receipt receipt : receipts) sumItems += receipt.getPurchasedItems();
		return sumItems;
	}
	


	

	//TODO : MERGE THESE FOUR METHODS
	public double calculateSkirtsSales(){
		double skirtSum = 0;
		for(Receipt receipt : receipts) {
			if(receipt.getProductType() == ProductType.SKIRT) skirtSum += receipt.getPurchasedItems();
		}
		return skirtSum;
	}

	public double calculateCoatsSales(){
		double coatsSum = 0;
		for(Receipt receipt : receipts) {
			if(receipt.getProductType() == ProductType.COAT) coatsSum += receipt.getPurchasedItems();
		}
		return coatsSum;
	}
	
	public double calculateTrouserSales(){
		double trousersSum = 0;
		for(Receipt receipt : receipts) {
			if(receipt.getProductType() == ProductType.TROUSERS) trousersSum += receipt.getPurchasedItems();
		}
		return trousersSum;
	}
	
	public double calculateShirtsSales(){
		double shirtSum = 0;
		for(Receipt receipt : receipts) {
			if(receipt.getProductType() == ProductType.SHIRT) shirtSum += receipt.getPurchasedItems();
		}
		return shirtSum;
	}
	// ^^				^^
	// || MERGEEEEEEE   ||
	




	public double calculateCommission(){
		double commission = 0;
		if( this.calculateTotalSales() > 6000 && this.calculateTotalSales()<= 10000){
			commission = 0.1*(calculateTotalSales()-6000);
		}
		else if(this.calculateTotalSales() > 10000 && this.calculateTotalSales() <= 40000 ){
			commission = (((calculateTotalSales() - 10000) * 0.15) + (10000*0.1));			
		}
		else if(this.calculateTotalSales() > 40000 ) {
			commission = 10000*0.1 + 30000*0.15 + (calculateTotalSales() - 40000)*0.2;			
		}
		return commission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAfm() {
		return afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	public List<Receipt> getReceipts() {
		return receipts;
	}

	public void setReceipts(List<Receipt> receipts) {
		this.receipts = receipts;
	}
}
