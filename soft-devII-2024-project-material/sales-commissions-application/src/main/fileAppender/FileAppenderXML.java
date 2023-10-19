package main.fileAppender;

import main.domain.Address;
import main.domain.Company;
import main.domain.ProductType;
import main.domain.Receipt;

import java.io.File;

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
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(receiptFile);
            transformer.transform(domSource, streamResult);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            //print line of error
            System.out.println("Line: " + e.getStackTrace()[0].getLineNumber());
        }
    }
    public static void main(String[] args) {
        FileAppenderXML fileAppenderXML = new FileAppenderXML();
        String filePath = "C:\\Users\\Philip\\Desktop\\UOI\\SD2\\soft-devII-2024\\soft-devII-2024-project-material\\test_input_files\\test-case-2-XML.xml";
        File file = new File(filePath);
        Receipt receipt = new Receipt(
            ProductType.SKIRT,
            123456,
            "2022-01-01",
            99.99,
            2,
            new Company(
                "Acme Inc.",
                new Address(
                    "USA",
                    "New York",
                    "Broadway",
                    123,
                    10001
                )
            )
        );
        fileAppenderXML.appendReceipt(receipt, file);
    }
}
