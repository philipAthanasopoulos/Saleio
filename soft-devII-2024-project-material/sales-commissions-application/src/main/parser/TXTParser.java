package main.parser;

import java.io.*;

import java.util.*;

import main.domain.*;

public class TXTParser extends Parser {

	//magic numbers
	int DATANAME = 0;
	int DATAVALUE = 1;
	int RECEIPTDATALENGTH = 10;
	int VALIDLINELENGTH = 2;
	int ASSOCIATEDATALENGTH = 2;

	@Override
	public Associate parseAssociateFromFile(File file) throws IOException, BadFileException{
		Associate resultAssociate = new Associate();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		Map<String, String> associateDataMap = new LinkedHashMap<String, String>(0);
		Map<String, String> receiptDataMap = new LinkedHashMap<String, String>(0);
		String line;
		
		//read first 2 lines for name and afm
		for(int i = 0; i < ASSOCIATEDATALENGTH; i++){
			line = bufferedReader.readLine();
			addLineToMap(line, associateDataMap);
			if(line == null) throw new BadFileException("Empty TXT file");
		}
		
		//read the rest of the lines for receipts
		while((line = bufferedReader.readLine()) != null){
			
			addLineToMap(line, receiptDataMap);

			if(receiptDataMap.size() == RECEIPTDATALENGTH){
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
				
				Receipt receipt;
				try {
					receipt = new Receipt(
						Integer.parseInt(receiptDataMap.get("Receipt ID")),
						receiptDataMap.get("Date"),
						ProductType.valueOf(receiptDataMap.get("Kind")),
						Double.parseDouble(receiptDataMap.get("Sales")),
						Integer.parseInt(receiptDataMap.get("Items")),
						company
					);
				}catch(Exception e){
					throw new BadFileException("File was missing information.");
				}
							
				resultAssociate.addReceipt(receipt);
				receiptDataMap.clear();
			}
		}

		bufferedReader.close();
		resultAssociate.setName(associateDataMap.get("Name"));
		resultAssociate.setAfm(associateDataMap.get("AFM"));
		resultAssociate.setPersonalFile(file);
		if(!resultAssociate.isValid()) throw new BadFileException("File was missing information.");
		return resultAssociate;
	}

	public void addLineToMap(String line, Map<String, String> map){
		try {
			String[] data = line.split(":");
			if(data.length == VALIDLINELENGTH) {
				map.put(
					data[DATANAME].trim(),
					data[DATAVALUE].trim()
				);
			}
		}catch(NullPointerException e) {
			throw new BadFileException("Empty TXT file.");
		}
	}
}
