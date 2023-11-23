package main.converter;

import java.io.*;

import main.domain.*;


public class TXTConverter extends Converter {
	
	public TXTConverter(Associate associate){
		this.associate = associate;
	}

    @Override
    public File convertFile(String path) throws IOException{
        File resultFile = new File(path, "report.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultFile));

        bufferedWriter.write(String.format("Name: %s%n", associate.getName()));
        bufferedWriter.write(String.format("AFM: %s%n%n", associate.getAfm()));
        bufferedWriter.write(String.format("Receipts: %n%n"));
        
        for(Receipt receipt : associate.getReceipts())
            bufferedWriter.write(receipt.toString()+"\n");
        
        bufferedWriter.close();

        return resultFile;
    }
}
