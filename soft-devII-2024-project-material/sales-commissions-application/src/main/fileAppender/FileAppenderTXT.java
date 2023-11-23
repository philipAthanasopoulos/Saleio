package main.fileAppender;

import main.domain.Receipt;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class FileAppenderTXT extends FileAppender{
	
	private FileWriter fileWriter;
	private BufferedWriter bufferedWriter;

	@Override
	protected void openFile() throws Exception  {
		fileWriter = new FileWriter(fileToAppend, true);
		bufferedWriter = new BufferedWriter(fileWriter);
	}

	@Override
	protected void writeReceipt() throws Exception {
		bufferedWriter.write(receiptToAppend.toString());
		bufferedWriter.newLine();
	}

	@Override
	protected void closeFile() throws Exception {
		bufferedWriter.close();
	}
}
