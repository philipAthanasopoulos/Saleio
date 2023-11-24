package test.fileAppender;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Paths;
import java.nio.file.Path;

import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import main.domain.*;
import main.fileAppender.FileAppenderXML;

public class FileAppenderXMLTest {

    FileAppenderXML fileAppenderXML;
    Receipt receiptToAppend;
    Associate associateToAppend;

    File associateFile ;
    File fileafterAppending;

    String fileContent;
    String expectedFileContent;

    @Before
    public void setUp() throws IOException, URISyntaxException {
        fileAppenderXML = new FileAppenderXML();
        URL originalFileUrl = getClass().getResource("/resources/test_input_files/test-case-1-XML.xml");
        File originalFile = new File(originalFileUrl.toURI());
        Path copiedFilePath = Paths.get(originalFileUrl.toURI()).resolveSibling("test-case-1-XML-copy.xml");
        Files.copy(originalFile.toPath(), copiedFilePath, StandardCopyOption.REPLACE_EXISTING);
        associateFile = copiedFilePath.toFile();
        fileafterAppending = new File(getClass().getResource("/resources/test_input_files/test-case-1-XML-after-appending.xml").getFile());
        receiptToAppend = new Receipt(170, "06/11/2023", ProductType.Coats, 2650, 60, "Zara", "Greece", "Ioannina", "Ch. Trikoupi", 28);
        associateToAppend = new Associate(associateFile);
    }

    @Test
    public void testAppendReceiptToFile() throws IOException {
        assertNotNull(associateFile);
        assertNotNull(fileafterAppending);

        try{
            fileAppenderXML.appendReceipt(receiptToAppend, associateToAppend);
        }catch(Exception e){
            fail("Exception thrown while appending receipt to file");
        }

        fileContent = new String(Files.readAllBytes(associateFile.toPath()));
        expectedFileContent = new String(Files.readAllBytes(fileafterAppending.toPath()));
        assertEquals(expectedFileContent, fileContent);
    }

    
}
