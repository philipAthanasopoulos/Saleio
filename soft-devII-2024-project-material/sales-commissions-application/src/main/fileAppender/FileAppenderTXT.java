package main.fileAppender;

import main.domain.Receipt;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class FileAppenderTXT extends FileAppender{

	@Override
	public void appendReceipt(Receipt receipt, File receiptFile) {
		try {
			writer = new BufferedWriter(new FileWriter(receiptFile, true));
			writer.write(receipt.toString());
			writer.close();
		} catch (NullPointerException fileNotFoundException) {
			System.out.println("File not found");
			fileNotFoundException.printStackTrace();
		} catch (Exception e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
    }
}
