package test.fileAppender;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import main.domain.*;
import main.fileAppender.FileAppenderTXT;

public class FileAppenderTest {
	
	File originalFile;
	File expectedFile;
	Receipt receiptToAdd;
	
	
	//TODO need to copy a file to a junit temporary folder, append the receipt to that file and then test the results.

	@Before
	public void setUp() throws Exception {

		Address address = new Address(
				"Greece",
				"Drama",
				"Papandreou",
				46
		);

		Company company = new Company(
				"Granazi",
				address
		);


		receiptToAdd = new Receipt(
				152,
				"11/10/2016",
				ProductType.Shirts,
				6025,
				400,
				company
		);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAppendReceipt() {
		FileAppenderTXT fileAppender = new FileAppenderTXT();
		fileAppender.appendReceipt(receiptToAdd);
		
	}

}
