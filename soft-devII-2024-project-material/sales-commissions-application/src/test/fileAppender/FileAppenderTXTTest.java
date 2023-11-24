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

import main.fileAppender.FileAppenderTXT;
import main.domain.*;

public class FileAppenderTXTTest {
    FileAppenderTXT fileAppenderTXT;
    Receipt receiptToAppend;
    Associate associateToAppend;

    File associateFile ;
    File fileafterAppending;

    String fileContent;
    String expectedFileContent;

    @Before
    public void setUp() throws IOException, URISyntaxException {
        fileAppenderTXT = new FileAppenderTXT();
        URL originalFileUrl = getClass().getResource("/resources/test_input_files/test-case-1-TXT.txt");
        File originalFile = new File(originalFileUrl.toURI());
        Path copiedFilePath = Paths.get(originalFileUrl.toURI()).resolveSibling("test-case-1-TXT-copy.txt");
        Files.copy(originalFile.toPath(), copiedFilePath, StandardCopyOption.REPLACE_EXISTING);
        associateFile = copiedFilePath.toFile();
        fileafterAppending = new File(getClass().getResource("/resources/test_input_files/test-case-1-TXT-after-appending.txt").getFile());
        receiptToAppend = new Receipt(7, "25/2/2014", ProductType.Trousers, 5000, 10, "Hand Made Clothes", "Greece", "Ioannina", "Kaloudi", 10);
        associateToAppend = new Associate(associateFile);
    }

    @Test
    public void testAppendReceiptToFile() throws IOException {
        assertNotNull(associateFile);
        assertNotNull(fileafterAppending);

        try{
            fileAppenderTXT.appendReceipt(receiptToAppend, associateToAppend);
        }catch(Exception e){
            fail("Exception thrown while appending receipt to file");
        }

        fileContent = new String(Files.readAllBytes(associateFile.toPath()));
        expectedFileContent = new String(Files.readAllBytes(fileafterAppending.toPath()));
        assertEquals(expectedFileContent, fileContent);
    }
}
