package main.domain;

import java.util.ArrayList;
import java.util.List;

import main.parser.Parser;
import main.parser.ParserFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;

public class Associate {
	private String name;
	private String afm;
	private List<Receipt> receipts;
	private File personalFile;

	public Associate(String name, String afm, List<Receipt> receipts, File personalFile) {
		this.name = name;
		this.afm = afm;
		this.receipts = receipts;
		this.personalFile = personalFile;
	}

	public Associate(){ //tmp empty constructor
		name = "Tmp";
		afm = "123";
		receipts = new ArrayList<Receipt>();
		personalFile = null;
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

	public void addReceipt(Receipt receipt) {
		receipts.add(receipt);
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
	
	public boolean isValid() {
		if (name == null || name.equals("")) return false;
		if (afm == null || afm.equals("")) return false;
		if (personalFile == null) return false;
		for(Receipt receipt : receipts) if (!receipt.isValid()) return false;
		return true;
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

	public File getPersonalFile() {
		return this.personalFile;
	}

	public void setPersonalFile(File personalFile) {
		this.personalFile = personalFile;
	}

	public String getFileType() {
		String fileType = "";
		String fileName = personalFile.getName();
		int dotIndex = fileName.lastIndexOf('.');
		fileType = (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
		System.out.println(fileType);
		return fileType;
	}
	
	public String getFormattedFile() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("Name: " + name + "\n")
				.append("AFM: " + afm + "\n");
				
		buffer.append("\n")
				.append("Receipts: \n")
				.append("\n");

		for(Receipt receipt : receipts) {
			buffer.append(receipt.toString() + "\n");
		}

		return buffer.toString();
	}

	public String getRawFile() {
		StringBuffer buffer = new StringBuffer();
		BufferedReader bufferedReader;

		try {
			bufferedReader = new BufferedReader(new FileReader(personalFile));
			String line = bufferedReader.readLine();

			while(line != null) {
				buffer.append(line + "\n");
				line = bufferedReader.readLine();
			}

			bufferedReader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return buffer.toString();
	}

	public ArrayList<ProductType> getAssociateProductTypes() {
		ArrayList<ProductType> productTypes = new ArrayList<ProductType>();

		for(Receipt receipt : receipts) {
			if(!productTypes.contains(receipt.getProductType())) {
				productTypes.add(receipt.getProductType());
			}
		}

		return productTypes;
	}

	public static void main(String[] args) {
		File file = new File("C:\\Users\\Philip\\Desktop\\UOI\\SD2\\soft-devII-2024\\soft-devII-2024-project-material\\test_input_files\\test-case-2-TXT.txt");
		ParserFactory parserFactory = new ParserFactory();
		Parser parser = parserFactory.getParser("text/plain");
		try {
			Associate associate =  parser.parseAssociateFromFile(file);
			System.out.println(associate.getReceipts().get(0).toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
