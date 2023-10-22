 package main.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import main.domain.Address;
import main.domain.Associate;
import main.domain.Company;
import main.domain.Entry;
import main.domain.ProductType;
import main.domain.Receipt;


public class TXTParser extends Parser {

	@Override
	public Entry parseFileEntry(File file) throws IOException {

		try {
			ArrayList<String> fileContentList = extractFileContent(file);
			Associate associate = extractAssociate(fileContentList);
			Entry resulEntry = new Entry(file , associate);

			return resulEntry;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Error parsing file");
			return null;
		}

	}

	@Override
	public Associate extractAssociate(ArrayList<String> fileContent) {
		String associateName , associateAfm;
		ArrayList<Receipt> receipts = new ArrayList<Receipt>();
		
		int associateNameIndex = fileContent.indexOf("Name");
		int associateAfmIndex = fileContent.indexOf("AFM");

		associateName = fileContent.get(associateNameIndex + 1);
		associateAfm = fileContent.get(associateAfmIndex + 1);

		//ghetto way to get the receipts
		//TODO: for some reason ProductType cannot be resolved ,FIX ME
		for(String word : fileContent){
			if(word.equals("Receipt ID")){
				int indexOfReceipt = fileContent.indexOf(word);

				int receiptID = Integer.parseInt(fileContent.get(indexOfReceipt + 1));
				String purchaseDate = fileContent.get(indexOfReceipt + 3);
				ProductType productType = null;
				double totalSales = Double.parseDouble(fileContent.get(indexOfReceipt + 7));
				int numberOfItems = Integer.parseInt(fileContent.get(indexOfReceipt + 9));
				String companyName = fileContent.get(indexOfReceipt + 11);
				String companyCountry = fileContent.get(indexOfReceipt + 13);
				String companyCity = fileContent.get(indexOfReceipt + 15);
				String companyStreet = fileContent.get(indexOfReceipt + 17);
				int companyNumber = Integer.parseInt(fileContent.get(indexOfReceipt + 19));
				Address address = new Address(companyCountry, companyCity, companyStreet, companyNumber);
				Company company = new Company(companyName, address);
				Receipt receipt = new Receipt(productType, receiptID, purchaseDate, totalSales, numberOfItems, company);
				receipts.add(receipt);
			}
		}
		Associate associate = new Associate(associateName, associateAfm, receipts);
		return associate;
	}

	public ArrayList<Receipt> extractReceipts(String fileContent) {
		return null;
	}

	@Override
	public ArrayList<String> extractFileContent(File file) {
		ArrayList<String> fileContentList = new ArrayList<String>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line = "";
			while((line = bufferedReader.readLine()) != null) {
				String[] lineSplit = line.split(":");
				fileContentList.addAll(Arrays.asList(lineSplit));
			}
			ArrayList<String> trimmedContentList = new ArrayList<String>();
			for(String word : fileContentList) trimmedContentList.add(word.trim());
			fileContentList = trimmedContentList;
			bufferedReader.close();
			return fileContentList;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error reading file");
			return null;
		}
	}

	public static void main(String[] args) {
		TXTParser parser = new TXTParser();
		File file = new File("C:\\Users\\Philip\\Desktop\\UOI\\SD2\\soft-devII-2024\\soft-devII-2024-project-material\\test_input_files\\test-case-1-TXT.txt");
		ArrayList<String> fileContent = parser.extractFileContent(file);
		 try {
		 	Entry entry = parser.parseFileEntry(file);
			// System.out.println(entry.getAssociate().getName());
			// System.out.println(entry.getAssociate().getAfm());
			// System.out.println(entry.getAssociate().getReceipts().toString());
		 } catch (IOException e) {
		 	// TODO Auto-generated catch block
		 	e.printStackTrace();
		 }
	}

	
}
