package main.fileAppender;

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

import main.domain.Receipt;

public class FileAppenderXML  extends FileAppender{

	@Override
    public void appendReceipt(Receipt receipt, File receiptFile) {
        try {
            //parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(receiptFile);

            //create a new Receipt element
            Element receiptElement = doc.createElement("Receipt");

            //create child elements and add them to the Receipt element
            Element receiptID = doc.createElement("ReceiptID");
            receiptID.setTextContent(String.valueOf(receipt.getReceiptID()));
            receiptElement.appendChild(receiptID);

            Element date = doc.createElement("Date");
            date.setTextContent(receipt.getPurchaseDate());
            receiptElement.appendChild(date);

            Element kind = doc.createElement("Kind");
            kind.setTextContent(receipt.getProductType().toString());
            receiptElement.appendChild(kind);

            Element sales = doc.createElement("Sales");
            sales.setTextContent(String.valueOf(receipt.getTotalSales()));
            receiptElement.appendChild(sales);

            Element items = doc.createElement("Items");
            items.setTextContent(String.valueOf(receipt.getNumberOfItems()));
            receiptElement.appendChild(items);

            Element company = doc.createElement("Company");
            company.setTextContent(receipt.getCompany().getCompanyName());
            receiptElement.appendChild(company);

            Element country = doc.createElement("Country");
            country.setTextContent(receipt.getCompany().getCompanyAddress().getCountry());
            receiptElement.appendChild(country);

            Element city = doc.createElement("City");
            city.setTextContent(receipt.getCompany().getCompanyAddress().getCity());
            receiptElement.appendChild(city);

            Element street = doc.createElement("Street");
            street.setTextContent(receipt.getCompany().getCompanyAddress().getStreet());
            receiptElement.appendChild(street);

            Element number = doc.createElement("Number");
            number.setTextContent(String.valueOf(receipt.getNumberOfItems()));
            receiptElement.appendChild(number);

            //add the Receipt element to the root element of the document
            doc.getDocumentElement().appendChild(receiptElement);

            //write the updated document back to the file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(receiptFile);
            transformer.transform(source, result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
