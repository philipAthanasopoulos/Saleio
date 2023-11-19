package main.fileAppender;

import main.domain.Receipt;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class FileAppenderTXT extends FileAppender{
	@Override
	public void appendReceipt(Receipt receipt, File receiptFile) throws Exception{
		writer = new BufferedWriter(new FileWriter(receiptFile, true));
		writer.write("\n");
		writer.write(receipt.toString());
		writer.close();
    }
}
