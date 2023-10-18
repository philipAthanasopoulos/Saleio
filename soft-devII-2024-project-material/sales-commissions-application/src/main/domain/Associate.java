package main.domain;

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
		int numOfItems = 0;
		for(Receipt receipt : receipts) numOfItems += receipt.getNumberOfItems();
		return numOfItems;
	}

	public double getSalesOfItem(ProductType productType){
		double sumOfItemSales = 0;
		for(Receipt receipt : receipts){
			if(receipt.getProductType() == productType) sumOfItemSales += receipt.getTotalSales();
		}
		return sumOfItemSales;
	}
	
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
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAfm() {
		return this.afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}

	public List<Receipt> getReceipts() {
		return this.receipts;
	}

	public void setReceipts(List<Receipt> receipts) {
		this.receipts = receipts;
	}	
}
