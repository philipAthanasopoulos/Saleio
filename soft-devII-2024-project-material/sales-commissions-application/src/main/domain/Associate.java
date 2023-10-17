package main.domain;

import java.util.ArrayList;
import java.util.List;

public class Associate {
	private String name;
	private String afm;
	private List<Receipt> receipts;
	private double skirtSales;
	private double coatSales;
	private double trouserSales;
	private double shirtSales;
	private double commission;

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
		for(Receipt receipt : receipts) sumItems += receipt.getNumberOfItems();
		return sumItems;
	}

	public void calculateSalesOfAllItems(){
		double skirtSum = 0, coatSum = 0, trouserSum = 0, shirtSum = 0;
		for(Receipt receipt : receipts) {
			switch(receipt.getProductType()){
				case SKIRT:
					skirtSum += receipt.getTotalSales();
					break;
				case COAT:
					coatSum += receipt.getTotalSales();
					break;
				case TROUSERS:
					trouserSum += receipt.getTotalSales();
					break;
				case SHIRT:
					shirtSum += receipt.getTotalSales();
					break;
				default:
					break;
			}
		}
		skirtSales = skirtSum;
		coatSales = coatSum;
		trouserSales = trouserSum;
		shirtSales = shirtSum;
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

	public double getSkirtSales() {
		return this.skirtSales;
	}

	public void setSkirtSales(double skirtSales) {
		this.skirtSales = skirtSales;
	}

	public double getCoatSales() {
		return this.coatSales;
	}

	public void setCoatSales(double coatSales) {
		this.coatSales = coatSales;
	}

	public double getTrouserSales() {
		return this.trouserSales;
	}

	public void setTrouserSales(double trouserSales) {
		this.trouserSales = trouserSales;
	}

	public double getShirtSales() {
		return this.shirtSales;
	}

	public void setShirtSales(double shirtSales) {
		this.shirtSales = shirtSales;
	}

	public double getCommission() {
		return this.commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}
	
}
