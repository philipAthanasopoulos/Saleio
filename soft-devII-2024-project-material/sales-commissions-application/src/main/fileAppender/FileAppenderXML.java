package main.fileAppender;

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

/*TODO: when appending a new receipt, the new one is correctly added but the old ones get spaced away
*probably because of transformer propetries at the end of the method
*PLS FIX
*/

public class FileAppenderXML  extends FileAppender{
    Document document;

	@Override
    public void appendReceipt(Receipt receipt, File receiptFile) throws Exception{

        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        document = documentBuilder.parse(receiptFile);
        document.getDocumentElement().normalize();

        NodeList receiptsList = document.getElementsByTagName("Receipts");
        Element receiptToAdd = document.createElement("Receipt");

        //TODO: convert to for loop, maybe with getValues(String value) method
        createElement("ReceiptID", receipt.getReceiptID(), receiptToAdd);
        createElement("Date", receipt.getPurchaseDate(), receiptToAdd);
        createElement("Kind", receipt.getProductType().name(), receiptToAdd);
        createElement("Sales", receipt.getTotalSales(), receiptToAdd);
        createElement("Items", receipt.getNumberOfItems(), receiptToAdd);
        createElement("Company", receipt.getCompanyName(), receiptToAdd);
        createElement("Country", receipt.getCompanyCountry(), receiptToAdd);
        createElement("City", receipt.getCompanyCity(), receiptToAdd);
        createElement("Street", receipt.getCompanyStreet(), receiptToAdd);
        createElement("Number", receipt.getCompanyStreetNumber(), receiptToAdd);

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
    }

    //temporay fix for the new line problem
    public void cleanBreakLines(File receiptFile) throws Exception {
        BufferedReader fileReader = new BufferedReader(new FileReader(receiptFile));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(receiptFile.getAbsolutePath() + ".tmp"));
        String line;

        while((line = fileReader.readLine()) != null) 
            if(!line.trim().isEmpty()) 
                fileWriter.write(line + System.getProperty("line.separator"));
        
        fileReader.close();
        fileWriter.close();

        Files.move(
            Paths.get(receiptFile.getAbsolutePath() + ".tmp"),
            Paths.get(receiptFile.getAbsolutePath()),
            StandardCopyOption.REPLACE_EXISTING
          );
    }

    private Element createElement(String name, Object data, Element parent){
		Element retElement = document.createElement(name);
        
        if(data instanceof String) retElement.appendChild(document.createTextNode((String) data));
        else if (data instanceof Integer) retElement.appendChild(document.createTextNode(String.valueOf(data)));
        else if (data instanceof Double) retElement.appendChild(document.createTextNode(String.valueOf(data)));
        
		if (parent != null) parent.appendChild(retElement);
		return retElement;
	}

}
