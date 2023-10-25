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

	public Company getCompany() {
		return company;
	}

	public ProductType getProductType() {
		return productType;
	}

	public String toString() {
		return "Receipt ID: " + receiptID + "\n" +
			   "Date: " + purchaseDate + "\n" +
			   "Kind: " + productTypeToString() + "\n" +
			   "Sales: " + totalSales + "\n" +
			   "Items: " + numberOfItems + "\n" +
			   "Company: " + company.getCompanyName() + "\n" +
			   "Country: " + company.getCompanyAddress().getCountry() + "\n" +
			   "City: " + company.getCompanyAddress().getCity() + "\n" +
			   "Street: " + company.getCompanyAddress().getStreet() + "\n" +
			   "Number: " + company.getCompanyAddress().getStreetNumber() + "\n";
	}

	public String productTypeToString(){
		if (productType == ProductType.INVALID) return null;
		if (productType == ProductType.Shirts) return "Shirts";
		if (productType == ProductType.Skirts) return "Skirts";
		if (productType == ProductType.Trousers) return "Trousers";
		return "Coats";

	}

	public ProductType stringToProductType(String type){
		if (type.equals("Shirts")) return ProductType.Shirts;
		if (type.equals("Skirts")) return ProductType.Skirts;
		if (type.equals("Trousers")) return ProductType.Trousers;
		if (type.equals("Coats")) return ProductType.Coats;
		return ProductType.INVALID;
	}

}
