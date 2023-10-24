package main.fileAppender;

import main.domain.Address;
import main.domain.Company;
import main.domain.ProductType;
import main.domain.Receipt;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;





/*TODO: when appending a new receipt, the new one is correctly added but the old ones get spaced away
*probably because of transformer propetries at the end of the method
*PLS FIX
*/

public class FileAppenderXML  extends FileAppender{

	@Override
    public void appendReceipt(Receipt receipt, File receiptFile) {
        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(receiptFile);
            document.getDocumentElement().normalize();

            NodeList receiptsList = document.getElementsByTagName("Receipts");

            Element receiptToAdd = document.createElement("Receipt");

            Element receiptId = document.createElement("ReceiptID");
            receiptId.setTextContent(Integer.toString(receipt.getReceiptID()));
            receiptToAdd.appendChild(receiptId);

            Element receiptDate = document.createElement("Date");
            receiptDate.setTextContent(receipt.getPurchaseDate());
            receiptToAdd.appendChild(receiptDate);

            Element receiptKind = document.createElement("Kind");
            receiptKind.setTextContent(receipt.getProductType().toString());
            receiptToAdd.appendChild(receiptKind);

            Element receiptNumberOfItems = document.createElement("Items");
            receiptNumberOfItems.setTextContent(Integer.toString(receipt.getNumberOfItems()));
            receiptToAdd.appendChild(receiptNumberOfItems);

            Element receiptCompany = document.createElement("Company");
            receiptCompany.setTextContent(receipt.getCompany().getCompanyName());
            receiptToAdd.appendChild(receiptCompany);

            Element receiptCompanyCountry = document.createElement("Country");
            receiptCompanyCountry.setTextContent(receipt.getCompany().getCompanyAddress().getCountry());
            receiptToAdd.appendChild(receiptCompanyCountry);

            Element receiptCompanyCity = document.createElement("City");
            receiptCompanyCity.setTextContent(receipt.getCompany().getCompanyAddress().getCity());
            receiptToAdd.appendChild(receiptCompanyCity);

            Element receiptCompanyStreet = document.createElement("Street");
            receiptCompanyStreet.setTextContent(receipt.getCompany().getCompanyAddress().getStreet());
            receiptToAdd.appendChild(receiptCompanyStreet);

            Element receiptCompanyNumber = document.createElement("Number");
            receiptCompanyNumber.setTextContent(Integer.toString(receipt.getCompany().getCompanyAddress().getStreetNumber()));
            receiptToAdd.appendChild(receiptCompanyNumber);

            receiptsList.item(0).appendChild(receiptToAdd);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(receiptFile);
            transformer.transform(domSource, streamResult);

            cleanBreakLines(receiptFile);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            //print line of error
            System.out.println("Line: " + e.getStackTrace()[0].getLineNumber());
        }
    }

    //temporay fix for the new line problem
    public void cleanBreakLines(File receiptFile) {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(receiptFile));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(receiptFile.getAbsolutePath() + ".tmp"));
            String line;
            while((line = fileReader.readLine()) != null) {
                if(line.trim().length() > 0) {
                    fileWriter.write(line + System.getProperty("line.separator"));
                }
            }
            fileReader.close();
            fileWriter.close();
            Files.move(Paths.get(receiptFile.getAbsolutePath() + ".tmp"), Paths.get(receiptFile.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error: " + e.getMessage());
        }
    }
}
