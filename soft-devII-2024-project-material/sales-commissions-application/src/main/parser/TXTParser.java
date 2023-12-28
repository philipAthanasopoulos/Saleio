package main.parser;

import java.io.*;

import java.util.*;

import main.domain.*;



public class TXTParser extends Parser {

	int DATANAMEINDEX = 0;
	int DATAVALUEINDEX = 1;
	int RECEIPTDATALENGTH = 10;
	int VALIDLINELENGTH = 2;
	int ASSOCIATEDATALENGTH = 2;
	
	@Override
	protected void setAssociateReceipts()
	throws FileNotFoundException, IOException, Exception {
		Map<String, String> receiptDataMap = new LinkedHashMap<String, String>(0);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToParse));
		String line;

		moveReaderToReceiptsSection(bufferedReader);
		
		while((line = bufferedReader.readLine()) != null){
			addLineToMap(line, receiptDataMap);
			
			if(receiptMapIsFull(receiptDataMap)){
				Receipt receipt = getReceiptFromMap(receiptDataMap);
				associateToParse.addReceipt(receipt);
				receiptDataMap.clear();
			}
		}
		bufferedReader.close();
	}

	private boolean receiptMapIsFull(Map<String, String> receiptDataMap) {
		return receiptDataMap.size() == RECEIPTDATALENGTH;
	}

	private void moveReaderToReceiptsSection(BufferedReader bufferedReader) throws IOException {
		String line;
		while((line = bufferedReader.readLine()) != null && !line.contains("Receipts:")){};
	}

	private Receipt getReceiptFromMap(Map<String, String> receiptDataMap) {
		Address address = new Address(
			receiptDataMap.get("Country"),
			receiptDataMap.get("City"),
			receiptDataMap.get("Street"),
			Integer.parseInt(receiptDataMap.get("Number"))
		);
			
		Company company = new Company(
			receiptDataMap.get("Company"),
			address
		);

		Receipt receipt = new Receipt(
			Integer.parseInt(receiptDataMap.get("Receipt ID")),
			receiptDataMap.get("Date"),
			ProductType.valueOf(receiptDataMap.get("Kind")),
			Double.parseDouble(receiptDataMap.get("Sales")),
			Integer.parseInt(receiptDataMap.get("Items")),
			company
		);

		return receipt;
	}
				
	@Override
	protected void setAssociateInfo() 
	throws FileNotFoundException, IOException, Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileToParse));
		Map<String, String> associateDataMap = new LinkedHashMap<String, String>(0);
		String line;
		for(int i = 0; i < ASSOCIATEDATALENGTH; i++){
			line = bufferedReader.readLine();
			addLineToMap(line, associateDataMap);
		}
		associateToParse.setName(associateDataMap.get("Name"));
		associateToParse.setAfm(associateDataMap.get("AFM"));
		associateToParse.setPersonalFile(fileToParse);

		bufferedReader.close();
	}
				
	private void addLineToMap(String line, Map<String, String> map) 
	throws Exception{
		String[] data = line.split(":");
		if(data.length == VALIDLINELENGTH) {
			map.put(
				data[DATANAMEINDEX].trim(),
				data[DATAVALUEINDEX].trim()
				);
		}
	}
}
				