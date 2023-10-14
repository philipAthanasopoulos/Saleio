package main.domain;


import java.util.ArrayList;
import java.util.List;

public class Associate {
	private String name;
	private String afm;
	private List<Receipt> receipts;
	private FileAppender fileAppender; // associate shouldn't have a file appender
									// it should be used by the main.gui

	public Associate(){
		receipts = new ArrayList<Receipt>();
	}
	
	public void setFileType(String fileType) {
		if(fileType.equals("TXT")){
			fileAppender = new FileAppenderTXT();
		}	
		else{
			fileAppender = new FileAppenderXML();
		}	
	}

	public double calculateTotalSales(){
		double sumSales = 0;
		for(Receipt receipt : receipts) sumSales += receipt.getSales();
		return sumSales;
	}
	

	public int calculateTotalItems(){
		int sumItems = 0;
		for(Receipt receipt : receipts) sumItems += receipt.getItems();
		return sumItems;
	}
	
	public float calculateSkirtsSales(){
		float skirtSum = 0;
		for(Receipt receipt : receipts) {
			if(receipt.getKind().equals("Skirt")) skirtSum += receipt.getItems();
		}
		return skirtSum;
	}

	public float calculateCoatsSales(){
		float coatsSum = 0;
		for(Receipt receipt : receipts) {
			if(receipt.getKind().equals("Coat")) coatsSum += receipt.getItems();
		}
		return coatsSum;
	}
	
	public float calculateTrouserSales(){
		float trousersSum = 0;
		for(Receipt receipt : receipts) {
			if(receipt.getKind().equals("Trouser")) trousersSum += receipt.getItems();
		}
		return trousersSum;
	}
	
	public float calculateShirtsSales(){
		float shirtSum = 0;
		for(Receipt receipt : receipts) {
			if(receipt.getKind().equals("Shirt")) shirtSum += receipt.getItems();
		}
		return shirtSum;
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

	public FileAppender getFileAppender() {
		return fileAppender;
	}

	public void setFileAppender(FileAppender fileAppender) {
		this.fileAppender = fileAppender;
	}
}
