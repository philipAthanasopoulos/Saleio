package main.domain;

public class Receipt {
	private ProductType productType;
	private int receiptID;
	private String purchaseDate;
	private double totalSales;
	private int numberOfItems;
	private Company company;
	
	public Receipt(ProductType productType, int receiptID, String purchaseDate, double totalSales, int numberOfItems, Company company){
		this.productType = productType; 
		this.receiptID = receiptID;
		this.purchaseDate = purchaseDate;
		this.totalSales = totalSales;
		this.numberOfItems = numberOfItems;
		this.company  = company;
	}

	public Receipt() {
		productType = ProductType.INVALID;
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
		return totalSales;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public Company getCompany() {
		return company;
	}

	public ProductType getProductType() {
		return productType;
	}

	public String toString(){
		return("ID : " + getReceiptID() + ", " + getPurchaseDate());
	}

	public static void main(String[] args) {
		Address address = new Address("Greece", "Athens", "Kifisias", 123, 123456789);
		Company company = new Company("Company", address);
		Receipt receipt = new Receipt(ProductType.SKIRT, 123, "12/12/2012", 123.123, 123, company);
		System.out.println(receipt);
	}
}
