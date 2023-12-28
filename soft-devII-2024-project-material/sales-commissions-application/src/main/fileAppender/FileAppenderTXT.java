package main.fileAppender;

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
		bufferedWriter.newLine();
		bufferedWriter.newLine();
		bufferedWriter.write(receiptToAppend.toString());
	}

	@Override
	protected void closeFile() throws Exception {
		bufferedWriter.close();
	}
}
