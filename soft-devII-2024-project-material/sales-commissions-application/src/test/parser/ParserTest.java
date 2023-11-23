package test.parser;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import main.domain.Associate;
import main.parser.*;

public class ParserTest {
	
	Parser parserTXT;
	Parser parserXML;
	Parser parserHTML;
	
	File testCase1TXT;
	File testCase2TXT;
	File testCase1XML;
	File testCase2XML;
	File testCase1HTML;
	File testCase2HTML;
	
	String sourceFolder = getClass().getResource("/resources/test_input_files/").getFile();

	@Before
	public void setUp() {
		ParserFactory parserFactory = new ParserFactory();
		
		parserTXT = parserFactory.getParser("txt");
		parserXML = parserFactory.getParser("xml");
		parserHTML = parserFactory.getParser("html");

		testCase1TXT = new File(getClass().getResource("/resources/test_input_files/test-case-1-TXT.txt").getFile());
		testCase2TXT = new File(getClass().getResource("/resources/test_input_files/test-case-2-TXT.txt").getFile());

		testCase1XML = new File(getClass().getResource("/resources/test_input_files/test-case-1-XML.xml").getFile());
		testCase2XML = new File(getClass().getResource("/resources/test_input_files/test-case-2-XML.xml").getFile());

		testCase1HTML = new File(getClass().getResource("/resources/test_input_files/test-case-1-HTML.html").getFile());
		// testCase2HTML = new File(getClass().getResource("/resources/test_input_files/test-case-2-HTML.html").getFile());
	}
	
	@Test
	public void testParseAssociateFromFile() {
		//Happy Day Scenarios
		try {
			Associate associate1 = parserTXT.parseAssociateFromFile(testCase1TXT);
			Associate associate2 = parserTXT.parseAssociateFromFile(testCase2TXT);
			Associate associate3 = parserXML.parseAssociateFromFile(testCase1XML);
			Associate associate4 = parserXML.parseAssociateFromFile(testCase2XML);
			Associate associate5 = parserHTML.parseAssociateFromFile(testCase1HTML);

			assertEquals("Apostolos Zarras", associate1.getName());
			assertEquals("Dimitris Papadopoulos", associate2.getName());
			assertEquals("Iosif Emmanouilidis", associate3.getName());
			assertEquals("Vassileios Zarras", associate4.getName());
			assertEquals("Apostolos Zarras", associate5.getName());

			assertEquals(associate1.getReceipts().size(), 18);
			assertEquals(associate2.getReceipts().size(), 4);
			assertEquals(associate3.getReceipts().size(), 4);
			assertEquals(associate4.getReceipts().size(), 16);
			assertEquals(associate5.getReceipts().size(), 4);

			assertEquals(associate1.getPersonalFile(), testCase1TXT);
			assertEquals(associate2.getPersonalFile(), testCase2TXT);
			assertEquals(associate3.getPersonalFile(), testCase1XML);
			assertEquals(associate4.getPersonalFile(), testCase2XML);
			assertEquals(associate5.getPersonalFile(), testCase1HTML);


		} catch (Exception e) {
			fail();
		}
	}
}
