package test.parser;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import main.domain.Associate;
import main.parser.*;

public class ParserTest {
	
	Parser parserTXT = null;
	Parser parserXML = null;
	Parser parserHTML = null;
	
	File testCase1TXT = null;
	File testCase1XML = null;
	File testCase1HTML = null;

	Associate associate1 = null;
	Associate associate2 = null;
	Associate associate3 = null;

	@Before
	public void setUp() {
		ParserFactory parserFactory = new ParserFactory();
		
		parserTXT = parserFactory.getParser("txt");
		parserXML = parserFactory.getParser("xml");
		parserHTML = parserFactory.getParser("html");

		testCase1TXT = new File(getClass().getResource("/resources/test_input_files/test-case-1-TXT.txt").getFile());
		testCase1XML = new File(getClass().getResource("/resources/test_input_files/test-case-1-XML.xml").getFile());
		testCase1HTML = new File(getClass().getResource("/resources/test_input_files/test-case-1-HTML.html").getFile());
	}
	
	@Test
	public void testParseAssociateFromFile() {
		//Happy Day Scenarios
		try {
			 associate1 = parserTXT.parseAssociateFromFile(testCase1TXT);
			 associate2 = parserXML.parseAssociateFromFile(testCase1XML);
			 associate3 = parserHTML.parseAssociateFromFile(testCase1HTML);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown when parsing associate from file");
		}

		assertEquals("Apostolos Zarras", associate1.getName());
		assertEquals("Iosif Emmanouilidis", associate2.getName());
		assertEquals("Apostolos Zarras", associate3.getName());

		assertEquals(associate1.getAfm(), "130456093");
		assertEquals(associate2.getAfm(), "171765698");
		assertEquals(associate3.getAfm(), "130456093");

		assertEquals(associate1.getReceipts().size(), 18);
		assertEquals(associate2.getReceipts().size(), 4);
		assertEquals(associate3.getReceipts().size(), 4);

		assertEquals(associate1.getPersonalFile(), testCase1TXT);
		assertEquals(associate2.getPersonalFile(), testCase1XML);
		assertEquals(associate3.getPersonalFile(), testCase1HTML);
	}
}
