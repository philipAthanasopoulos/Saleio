package main.fileAppender;

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
    protected void openFile() throws Exception {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        document = documentBuilder.parse(fileToAppend);
        document.getDocumentElement().normalize();
    }

    @Override
    protected void writeReceipt() throws Exception {
        NodeList receiptsList = document.getElementsByTagName("Receipts");
        Element receiptToAppendElement = document.createElement("Receipt");

        createElement("ReceiptID", receiptToAppend.getReceiptID(), receiptToAppendElement);
        createElement("Date", receiptToAppend.getPurchaseDate(), receiptToAppendElement);
        createElement("Kind", receiptToAppend.getProductType().name(), receiptToAppendElement);
        createElement("Sales", receiptToAppend.getTotalSales(), receiptToAppendElement);
        createElement("Items", receiptToAppend.getNumberOfItems(), receiptToAppendElement);
        createElement("Company", receiptToAppend.getCompanyName(), receiptToAppendElement);
        createElement("Country", receiptToAppend.getCompanyCountry(), receiptToAppendElement);
        createElement("City", receiptToAppend.getCompanyCity(), receiptToAppendElement);
        createElement("Street", receiptToAppend.getCompanyStreet(), receiptToAppendElement);
        createElement("Number", receiptToAppend.getCompanyStreetNumber(), receiptToAppendElement);

        receiptsList.item(0).appendChild(receiptToAppendElement);
    }

    @Override
    protected void closeFile() throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(fileToAppend);
        transformer.transform(domSource, streamResult);

        cleanBreakLines(fileToAppend);
    }

    //temporay fix for the new line problem
    public void cleanBreakLines(File receiptFile) throws Exception {
        BufferedReader fileReader = new BufferedReader(new FileReader(receiptFile));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(receiptFile.getAbsolutePath() + ".tmp"));
        String line;

        while((line = fileReader.readLine()) != null) 
            if(!line.trim().isEmpty()) 
                fileWriter.write(line + System.getProperty("line.separator")); // "\n" doesnt work for some reason
        
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
