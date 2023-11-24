package test.fileAppender;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.junit.Before;
import org.junit.Test;

import main.domain.Receipt;
import main.fileAppender.FileAppenderHTML;
import main.domain.Associate;
import main.domain.ProductType;


public class FileAppenderHTMLTest {
    FileAppenderHTML fileAppenderHTML;
    Associate associateToAppend;
    Receipt receiptToAppend;
    
    File associateFile ;
    File fileafterAppending;

    String fileContent;
    String expectedFileContent;

    @Before
    public void setUp() throws URISyntaxException, IOException {
        fileAppenderHTML = new FileAppenderHTML();
        URL originalFileUrl = getClass().getResource("/resources/test_input_files/test-case-1-HTML.html");
        File originalFile = new File(originalFileUrl.toURI());
        Path copiedFilePath = Paths.get(originalFileUrl.toURI()).resolveSibling("test-case-1-HTML-copy.html");
        Files.copy(originalFile.toPath(), copiedFilePath, StandardCopyOption.REPLACE_EXISTING);
        associateFile = copiedFilePath.toFile();
        fileafterAppending = new File(getClass().getResource("/resources/test_input_files/test-case-1-HTML-after-appending.html").getFile());
        receiptToAppend = new Receipt(1, "2019-01-01", ProductType.Boots, 100, 1, "Company1", "Country1", "City1", "Street1", 1);
        associateToAppend = new Associate(associateFile);
    }

    @Test
    public void testAppendReceiptToFile() throws IOException {
        assertNotNull(associateFile);
        assertNotNull(fileafterAppending);

        try{
            fileAppenderHTML.appendReceipt(receiptToAppend, associateToAppend);
        }catch(Exception e){
            System.out.println("Error appending receipt to file");
            e.getMessage();
        }

        fileContent = new String(Files.readAllBytes(associateFile.toPath()));
        expectedFileContent = new String(Files.readAllBytes(fileafterAppending.toPath()));
        assertEquals(expectedFileContent, fileContent );
    }
}
