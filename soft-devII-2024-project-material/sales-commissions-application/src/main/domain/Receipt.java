package main.domain;
public class Receipt {

	private ProductType productType;
	private int receiptID;
	private String purchaseDate;
	private double totalSales;
	private int purchasedItems;
	private Company company;
	
	public Receipt(ProductType productType, 
			int receiptID, 
			String purchaseDate, 
			double totalSales, 
			int purchasedItems, 
			Company company){

		this.productType = productType; 
		this.receiptID = receiptID;
		this.purchaseDate = purchaseDate;
		this.totalSales = totalSales;
		this.purchasedItems = purchasedItems;
		//TODO : fix company constructor, so that it actually works.
		this.company  = company;
	}

	public Receipt(){ //empty overwrite
		
		productType = ProductType.INVALID;
		company = new Company();
	}

	public int getReceiptID() {
		return receiptID;
	}

	public void setReceiptID(int receiptID) {
		this.receiptID = receiptID;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public double getTotalSales() {
		return sales;
	}

	public int getPurchasedItems() {
		return items;
	}

	public Company getCompany() {
		return company;
	}

	public ProductType getProductType() {
		return productType;
	}

	public String toString(){
		return("ID : "+getReceiptID()+", "+getPurchaseDate());
	}
}
