 package main.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class TXTParser extends Parser {

	public TXTParser(File recieptFileTXT){
		this.inputFile = recieptFileTXT;
		inputFilePath =  inputFile.getAbsolutePath();
	}
	@Override
	public void readFile() {
		BufferedReader bufferedReader = null;
	    String line;
	    try {
			bufferedReader = new BufferedReader(new FileReader(inputFilePath));

			while ((line = bufferedReader.readLine()) != null) {
				if(line.startsWith("Name:")){
					name = (line.substring(line.indexOf(":") + 1).trim());
					continue;
				}
				if(line.startsWith("AFM")){
					afm = (line.substring(line.indexOf(":") + 1).trim());
					addAgent();
					continue;
				}
				if(line.startsWith("Receipts")){
					continue;
				}
				if(line.startsWith("Receipt ID")){
					receiptID = (Integer.parseInt(line.substring
					(line.indexOf(":") + 1).trim()));
					continue;
				}
				if(line.startsWith("Date")){
					date = (line.substring(line.indexOf(":") + 1).trim());
					continue;
				}
				if(line.startsWith("Kind")){
					kind = (line.substring(line.indexOf(":") + 1).trim());
					continue;
				}
				if(line.startsWith("Sales")){
					sales = (Double.parseDouble(line.substring
					(line.indexOf(":") + 1).trim()));
					continue;
				}
				if(line.startsWith("Items")){
					items = (Integer.parseInt(line.substring
					(line.indexOf(":") + 1).trim()));
					continue;
				}
				if(line.startsWith("Company")){
					companyName = (line.substring
					(line.indexOf(":") + 1).trim());
					continue;
				}
				if(line.startsWith("Country")){
					companyCountry =  (line.substring
					(line.indexOf(":") + 1).trim());
					continue;
				}
				if(line.startsWith("City")){
					companyCity =  (line.substring
					(line.indexOf(":") + 1).trim());
					continue;
				}
				if(line.startsWith("Street")){
					companyStreet =  (line.substring
					(line.indexOf(":") + 1).trim());
					continue;
				}
				if(line.startsWith("Number")){
					companyStreetNumber =  (Integer.parseInt
					(line.substring(line.indexOf(":") + 1).trim()));
					addReceipt();
					continue;
				}
			}
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("Error reading file");
			e.printStackTrace();
		}
	}
}
