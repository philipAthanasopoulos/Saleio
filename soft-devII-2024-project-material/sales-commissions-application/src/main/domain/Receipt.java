package main.domain;

public class Receipt {
	private ProductType productType;
	private int receiptID;
	private String purchaseDate;
	private double totalSales;
	private int numberOfItems;
	private Company company;
	
	public Receipt(String productType, int receiptID, String purchaseDate, double totalSales, int numberOfItems, Company company) {
		this.productType = stringToProductType(productType); 
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

	public static void main(String[] args) {
		Address address = new Address("Greece", "Athens", "Kifisias", 123);
		Company company = new Company("Company", address);
		Receipt receipt = new Receipt(ProductType.Skirts, 123, "12/12/2012", 123.123, 123, company);
		System.out.println(receipt);
	}
}
