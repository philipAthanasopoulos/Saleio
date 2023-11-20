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
        BufferedWriter writeStream = new BufferedWriter(new FileWriter(resultFile));

        writeStream.write(String.format("Name: %s%n", associate.getName()));
        writeStream.write(String.format("AFM: %s%n%n", associate.getAfm()));
        writeStream.write(String.format("Receipts: %n%n"));
        
        for(Receipt receipt : associate.getReceipts())
            writeStream.write(receipt.toString()+"\n");
        
        writeStream.close();

        return resultFile;
    }
}
