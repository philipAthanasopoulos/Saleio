package main.domain;

public class Receipt {
	private int receiptID;
	private String purchaseDate;
	private ProductType productType;
	private double totalSales;
	private int numberOfItems;
	private Company company;
	
	public Receipt(int receiptID, String purchaseDate, ProductType productType, double totalSales, int numberOfItems, Company company) {
		this.productType = productType;
		this.receiptID = receiptID;
		this.purchaseDate = purchaseDate;
		this.totalSales = totalSales;
		this.numberOfItems = numberOfItems;
		this.company  = company; //TODO : Where is company constructed? Let's work on this
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

	protected Company getCompany() {
		return company;
	}

	public String getCompanyName(){
		return getCompany().getCompanyName();
	}

	public String getCompanyCountry(){
		return company.getAddressCountry();
	}

	public String getCompanyCity(){
		return company.getAddressCity();
	}

	public String getCompanyStreet(){
		return company.getAddressStreet();
	}

	public int getCompanyStreetNumber(){
		return company.getAddressNumber();
	}

	public ProductType getProductType() {
		return productType;
	}

	public String toString() {
		return "Receipt ID: " + receiptID + "\n" +
			   "Date: " + purchaseDate + "\n" +
			   "Kind: " + productType + "\n" +
			   "Sales: " + totalSales + "\n" +
			   "Items: " + numberOfItems + "\n" +
			   "Company: " + company.getCompanyName() + "\n" +
			   "Country: " + getCompanyCountry() + "\n" +
			   "City: " + getCompanyCity() + "\n" +
			   "Street: " + getCompanyStreet() + "\n" +
			   "Number: " + getCompanyStreetNumber() + "\n";
	}
}
