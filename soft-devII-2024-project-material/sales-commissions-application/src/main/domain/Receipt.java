package main.domain;

public class Receipt {
	private int receiptID;
	private String purchaseDate;
	private ProductType productType;
	private double totalSales;
	private int numberOfItems;
	private Company company;
	
	public Receipt(int receiptID, String purchaseDate, ProductType productType, double totalSales, int numberOfItems, Company company) {
		this.receiptID = receiptID;
		this.purchaseDate = purchaseDate;
		this.productType = productType;
		this.totalSales = totalSales;
		this.numberOfItems = numberOfItems;
		this.company  = company; //TODO : Where is company constructed? Let's work on this
	}

	public Receipt(int receiptID, String purchaseDate, ProductType productType, double totalSales, int numberOfItems, String companyName, String companyCountry, String companyCity, String companyStreet, int companyStreetNumber) {
		this.receiptID = receiptID;
		this.purchaseDate = purchaseDate;
		this.productType = productType;
		this.totalSales = totalSales;
		this.numberOfItems = numberOfItems;
		this.company = new Company(companyName, companyCountry, companyCity, companyStreet, companyStreetNumber);
	}

	public Receipt() {
		productType = ProductType.INVALID;
	}
	
	public boolean isValid() {
		if (purchaseDate == null || purchaseDate.isEmpty()) return false;
		if (productType == null || productType == ProductType.INVALID) return false;
		if (getCompanyName() == null || getCompanyName().isEmpty()) return false;
		if (getCompanyCountry() == null || getCompanyCountry().isEmpty()) return false;
		if (getCompanyCity() == null || getCompanyCity().isEmpty()) return false;
		if (getCompanyStreet() == null || getCompanyStreet().isEmpty()) return false;
		return true;
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
		return "Receipt ID: " + receiptID + "\r\n" +
			   "Date: " + purchaseDate + "\r\n" +
			   "Kind: " + productType + "\r\n" +
			   "Sales: " + totalSales + "\r\n" +
			   "Items: " + numberOfItems + "\r\n" +
			   "Company: " + company.getCompanyName() + "\r\n" +
			   "Country: " + getCompanyCountry() + "\r\n" +
			   "City: " + getCompanyCity() + "\r\n" +
			   "Street: " + getCompanyStreet() + "\r\n" +
			   "Number: " + getCompanyStreetNumber();
	}
}
