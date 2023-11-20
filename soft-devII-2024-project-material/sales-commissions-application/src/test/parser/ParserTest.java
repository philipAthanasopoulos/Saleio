package test.parser;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import main.parser.*;

public class ParserTest {
	
	Parser parserTXT;
	Parser parserXML;
	
	File testCase1TXT;
	File testCase2TXT;
	File testCase1XML;
	File testCase2XML;
	File emptyTXT;
	File emptyXML;
	File wrongTXT;
	File wrongXML;

	@Before
	public void setUp() {
		ParserFactory pF = new ParserFactory();
		
		parserTXT = pF.getParser("txt");
		parserXML = pF.getParser("xml");
		
		testCase1TXT = new File("C:\\\\Users\\\\iosif\\\\cs\\\\Semester7\\\\SoftwareDevelopment2\\\\Project\\\\soft-devII-2024\\\\soft-devII-2024-project-material\\\\test_input_files\\\\test-case-1-TXT.txt");
		testCase2TXT = new File("C:\\\\Users\\\\iosif\\\\cs\\Semester7\\SoftwareDevelopment2\\Project\\soft-devII-2024\\soft-devII-2024-project-material\\test_input_files\\test-case-2-TXT.txt");
		testCase1XML = new File("C:\\Users\\iosif\\cs\\Semester7\\SoftwareDevelopment2\\Project\\soft-devII-2024\\soft-devII-2024-project-material\\test_input_files\\test-case-1-XML.xml");
		testCase2XML = new File("C:\\Users\\iosif\\cs\\Semester7\\SoftwareDevelopment2\\Project\\soft-devII-2024\\soft-devII-2024-project-material\\test_input_files\\test-case-2-XML.xml");
		emptyTXT = new File("C:\\Users\\iosif\\cs\\Semester7\\SoftwareDevelopment2\\Project\\soft-devII-2024\\soft-devII-2024-project-material\\test_input_files\\empty-file.txt");
		emptyXML = new File("C:\\Users\\iosif\\cs\\Semester7\\SoftwareDevelopment2\\Project\\soft-devII-2024\\soft-devII-2024-project-material\\test_input_files\\empty-file.xml");
		wrongTXT = new File("C:\\Users\\iosif\\cs\\Semester7\\SoftwareDevelopment2\\Project\\soft-devII-2024\\soft-devII-2024-project-material\\test_input_files\\test-case-wrong-TXT.txt");
		wrongXML = new File("C:\\Users\\iosif\\cs\\Semester7\\SoftwareDevelopment2\\Project\\soft-devII-2024\\soft-devII-2024-project-material\\test_input_files\\test-case-wrong-XML.xml");
	}
	
	@Test
	public void testParseAssociateFromFile() {
		//Happy Day Scenarios
		//TODO fix Receipt.toString, to be able to test if the things that enter are correctly implemented into the struct.
		try {
			assertTrue(parserTXT.parseAssociateFromFile(testCase1TXT).isValid());
			assertTrue(parserTXT.parseAssociateFromFile(testCase2TXT).isValid());
			assertTrue(parserXML.parseAssociateFromFile(testCase1XML).isValid());
			assertTrue(parserXML.parseAssociateFromFile(testCase2XML).isValid());
		} catch (Exception e) {
			fail();
		} catch (Exception e) {
			fail();
		}
		
		//Rainy Day Scenarios
		assertThrows(Exception.class,() -> parserTXT.parseAssociateFromFile(emptyTXT));
		
		assertThrows(Exception.class,() -> parserXML.parseAssociateFromFile(emptyXML));
		
		assertThrows(Exception.class,() -> parserTXT.parseAssociateFromFile(wrongTXT));
		
		assertThrows(Exception.class,() -> parserXML.parseAssociateFromFile(wrongXML));
	}

}
