package data;

public class Receipt {
	protected int receiptId;
	protected String date;
	protected double sales;
	protected int items;
	protected Company company;
	protected String kind;
		
	
	public Receipt(){
		
		kind = new String("No specific kind");
		company  = new Company();
	}
	
	public Company getCompany(){
		
		return company;
	}

	public String getKind() {
		return kind;
		
	}

	
	public double getSales() {
		return sales;
	}

	
	public void setSales(double sales) {

		this.sales = sales;
	}

	
	public void setItems(int items) {
		this.items = items;
	}

	
	public int getItems() {
		return this.items;
	}

	
	public void setReceiptID(int id) {
		this.receiptId = id;		
		
	}

	
	public int getReceiptID() {
		return receiptId;
	}

	
	public void setDate(String date) {
		this.date = date;
	}

	
	public String getDate() {
		return date;			
	}
	
	
	
}
