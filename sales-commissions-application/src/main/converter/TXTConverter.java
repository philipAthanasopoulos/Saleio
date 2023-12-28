package main.converter;

import java.io.*;

import main.domain.*;


public class TXTConverter extends Converter {
	
	public TXTConverter(){
        this.extension = "txt";
	}

    @Override
    public void writeAssociateInfo(Associate associate) throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(convertedFile));
        bufferedWriter.write(String.format("Name: %s%n", associate.getName()));
        bufferedWriter.write(String.format("AFM: %s%n%n", associate.getAfm()));
        bufferedWriter.close();
    }

    @Override
    public void writeReceipts(Associate associate) throws IOException{
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(convertedFile, true));
        bufferedWriter.write(String.format("Receipts: %n%n"));
        
        for(Receipt receipt : associate.getReceipts())
            bufferedWriter.write(receipt.toString()+"\n");
        
        bufferedWriter.close();
    }

    @Override
    public void saveFile() throws IOException{
        // convertedFile.createNewFile();
    }
}
