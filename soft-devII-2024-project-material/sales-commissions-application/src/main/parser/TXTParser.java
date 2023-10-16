 package main.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;



public class TXTParser extends Parser {

	public TXTParser(File receiptFileTXT){
		this.inputFile = receiptFileTXT;
		inputFilePath =  inputFile.getAbsolutePath();
	}
	@Override
	public void readFile()  {
		try{
			List<String> wordsOfFile = new ArrayList<>();
			BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
			String line;
			while((line = bufferedReader.readLine()) != null){
				line = line.replaceAll(":\\s+",":");
				String[] words = line.split(":");
				wordsOfFile.addAll(Arrays.asList(words));
			}

			for(String word : wordsOfFile){
				String nextWord = wordsOfFile.get(wordsOfFile.indexOf(word) + 1);
				switch (word){
					case "Name":
						name = nextWord;
						break;
					case "AFM":
						afm = nextWord;
						break;
					case "Receipts":
						break;
					case "Receipt":
						receiptID = Integer.parseInt(nextWord);
						break;
					case "Date":
						date = nextWord;
						break;
					case "Kind":
						kind = nextWord;
						break;
					case "Sales":
						sales = Double.parseDouble(nextWord);
						break;
					case "Items":
						items = Integer.parseInt(nextWord);
						break;
					case "Company":
						companyName = nextWord;
						break;
					case "Country":
						companyCountry = nextWord;
						break;
					case "City":
						companyCity = nextWord;
						break;
					case "Street":
						companyStreet = nextWord;
						break;
					case "Number":
						companyStreetNumber = Integer.parseInt(nextWord);
						break;
					default:
						break;
				}
				addAgent();
				addReceipt();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		File file = new File("C:\\Users\\Philip\\Desktop\\UOI\\SD2\\soft-devII-2024\\soft-devII-2024-project-material\\sales-commissions-application\\resources\\test-case-1-TXT.txt");
		TXTParser parser = new TXTParser(file);
		parser.readFile();
	}
}
