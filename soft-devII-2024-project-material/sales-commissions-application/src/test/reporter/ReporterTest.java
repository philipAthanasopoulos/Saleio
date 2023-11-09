package test.reporter;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import main.domain.*;
import main.reporter.*;
import main.parser.*;

public class ReporterTest {
	
	Reporter reporterTXT;
	Reporter reporterXML;
	File testFile;
	File txt;
	File xml;
	Parser parser;
	Associate associateTXT;
	Associate associateXML;
	TemporaryFolder folder;

	@Before
	public void setUp() throws Exception {
		folder = new TemporaryFolder();
		folder.create();
		txt = folder.newFile();
		xml = folder.newFile();
		testFile = new File("C:\\Users\\iosif\\cs\\Semester7\\SoftwareDevelopment2\\Project\\soft-devII-2024\\soft-devII-2024-project-material\\test_input_files\\test-case-1-TXT.txt");
		parser = new TXTParser();
		associateTXT = parser.parseAssociateFromFile(testFile);
		parser = new XMLParser();
		testFile = new File("C:\\Users\\iosif\\cs\\Semester7\\SoftwareDevelopment2\\Project\\soft-devII-2024\\soft-devII-2024-project-material\\test_input_files\\test-case-1-XML.xml");
		associateXML = parser.parseAssociateFromFile(testFile);
	}

	@After
	public void tearDown() throws Exception {
		folder.delete();
	}

	@Test
	public void testComposeReportFile() {
		//Rainy day scenarios
		reporterTXT = new TXTReporter(associateTXT);
		reporterXML = new XMLReporter(associateXML);
		
		assertThrows(IOException.class, () -> reporterTXT.composeReportFile(txt.getPath()));
		//TODO fix reporterXML
		//assertThrows(IOException.class, () -> reporterXML.composeReportFile(xml.getPath()));
		
		//Happy day scenarios
		reporterTXT = new TXTReporter(associateTXT);
		reporterXML = new XMLReporter(associateXML);
		
		try {
			reporterTXT.composeReportFile(txt.getParent());
			reporterXML.composeReportFile(xml.getParent());
		}catch(IOException e) {
			fail("EException not supposed to be thrown");
		}
		//How do we assert if equals??
		fail("Not yet implemented!!!");
	}

}
