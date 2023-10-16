package main.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppenderTXT extends FileAppender{

	public  void setFileToAppend(File fileToAppend) {
		this.fileToAppend = fileToAppend;
	}

	public void appendFile(){
		System.out.println("Mpike sto TXT");
		System.out.println(fileToAppend.getAbsolutePath());
		try {
			FileWriter fileWriter = new FileWriter(fileToAppend,true);		
			fileWriter.write("\n");
			fileWriter.write("Receipt ID: ");
			fileWriter.write(receiptID);
			fileWriter.write("\n");

			fileWriter.write("Date: ");
			fileWriter.write(date);
			fileWriter.write("\n");

			fileWriter.write("Kind: ");
			fileWriter.write(kind);
			fileWriter.write("\n");

			fileWriter.write("Sales: ");
			fileWriter.write(sales);
			fileWriter.write("\n");

			fileWriter.write("Items: ");
			fileWriter.write(items);
			fileWriter.write("\n");

			fileWriter.write("Company: ");
			fileWriter.write(company);
			fileWriter.write("\n");

			fileWriter.write("Country: ");
			fileWriter.write(country);
			fileWriter.write("\n");
			
			fileWriter.write("City: ");
			fileWriter.write(city);
			fileWriter.write("\n");

			fileWriter.write("Street: ");
			fileWriter.write(street);
			fileWriter.write("\n");

			fileWriter.write("Number: ");
			fileWriter.write(number);
			fileWriter.write("\n");

			fileWriter.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setReceiptID(String receiptID) {
		this.receiptID = receiptID;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}



	public void setSales(String sales) {
		this.sales = sales;
	}



	public void setItems(String items) {
		this.items = items;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setStreet(String street) {
		this.street = street;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public static void main(String[] args) {
		File file = new File("C:\\Users\\Philip\\Desktop\\UOI\\SD2\\soft-devII-2024\\soft-devII-2024-project-material\\test_input_files\\newFile.txt");
		FileAppenderTXT fileAppenderTXT = new FileAppenderTXT();
		fileAppenderTXT.setFileToAppend(file);
		fileAppenderTXT.setReceiptID("123");
		fileAppenderTXT.setDate("12/12/12");
		fileAppenderTXT.setKind("Skirt");
		fileAppenderTXT.setSales("123");
		fileAppenderTXT.setItems("123");
		fileAppenderTXT.setCompany("Zara");
		fileAppenderTXT.setCountry("Greece");
		fileAppenderTXT.setCity("Athens");
		fileAppenderTXT.setStreet("Kifisias");
		fileAppenderTXT.setNumber("200");
		fileAppenderTXT.appendFile();

	}

}
