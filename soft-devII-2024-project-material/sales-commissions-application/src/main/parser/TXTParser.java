package main.parser;

import java.io.*;

import java.util.*;

import main.domain.*;

public class TXTParser extends Parser {

	int DATANAME = 0;
	int DATAVALUE = 1;

	@Override
	public Entry parseFileEntry(File file) throws IOException {

		BufferedReader readStream;

		try {
			readStream = new BufferedReader(new FileReader(file));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Σφαλμα κατα το ανοιγμα του αρχείου");
			return null;
		}

		//TODO : Maybe rework this first part, possibly by setting
		String line = readStream.readLine();
		String associateName = extractDataValue(line);
		line = readStream.readLine();
		String associateAFM = extractDataValue(line);

		List<Receipt> receipts = new ArrayList<Receipt>();

		

		while(!extractDataName(readStream.readLine()).equals("Receipts")) continue;

		readStream.readLine();

		//TODO : Work around NULL lines, cause it is currently not working properly.

		while (line!= null){
			String receiptID = extractDataValue(readStream.readLine());
			String purchaseDate = extractDataValue(readStream.readLine());
			String itemKind = extractDataValue(readStream.readLine());
			String totalSales = extractDataValue(readStream.readLine());
			String itemsPurchased = extractDataValue(readStream.readLine());
			String companyName = extractDataValue(readStream.readLine());
			String companyAddressCountry = extractDataValue(readStream.readLine());
			String companyAddressCity = extractDataValue(readStream.readLine());
			String companyAddressStreet = extractDataValue(readStream.readLine());
			String companyAddressNumber = extractDataValue(readStream.readLine());

			Receipt receipt = new Receipt(itemKind,
					Integer.valueOf(receiptID),
					purchaseDate,
					Double.valueOf(totalSales),
					Integer.valueOf(itemsPurchased),
					new Company(companyName,
						new Address(companyAddressCountry,
							companyAddressCity,
							companyAddressStreet,
							Integer.valueOf(companyAddressNumber)
						)
					)
				);
			
			receipts.add(receipt);
			
			readStream.readLine();
		}


		readStream.close();
		return new Entry(file,
			new Associate(associateName,
				associateAFM,
				receipts
			)
		);
	}

	private String extractDataName(String line){
		if (line == null || line.equals("")) return "";
		String[] lineDivided =  line.split(":");
		return lineDivided[DATANAME].trim();
	}

	private String extractDataValue(String line){
		if (line == null || line.equals("")) return "";
		String[] lineDivided =  line.split(":");
		return lineDivided[DATAVALUE].trim();
	}

	public static void main(String[] args) {
		return;
	}

	
}
