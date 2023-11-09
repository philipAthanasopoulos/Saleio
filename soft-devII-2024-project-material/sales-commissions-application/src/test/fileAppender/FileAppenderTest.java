package test.fileAppender;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import main.domain.*;

public class FileAppenderTest {
	
	File originalFile;
	File expectedFile;
	Receipt receiptToAdd;
	
	//TODO need to copy a file to a junit temporary folder, append the receipt to that file and then test the results.

	@Before
	public void setUp() throws Exception {
		receiptToAdd = new Receipt();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAppendReceipt() {
		fail("Not yet implemented");
	}

}
