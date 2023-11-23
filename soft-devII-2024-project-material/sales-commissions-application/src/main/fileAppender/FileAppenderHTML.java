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

public class FileAppenderHTML extends FileAppender {

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
        //get html table
        NodeList receiptsTable = document.getElementsByTagName("table");
        Element tableRow = document.createElement("tr");

        //create table cells
        createElement("td", receiptToAppend.getReceiptID(), tableRow);
        createElement("td", receiptToAppend.getPurchaseDate(), tableRow);
        createElement("td", receiptToAppend.getProductType().name(), tableRow);
        createElement("td", receiptToAppend.getTotalSales(), tableRow);
        createElement("td", receiptToAppend.getNumberOfItems(), tableRow);
        createElement("td", receiptToAppend.getCompanyName(), tableRow);
        createElement("td", receiptToAppend.getCompanyCountry(), tableRow);
        createElement("td", receiptToAppend.getCompanyCity(), tableRow);
        createElement("td", receiptToAppend.getCompanyStreet(), tableRow);
        createElement("td", receiptToAppend.getCompanyStreetNumber(), tableRow);

        receiptsTable.item(0).appendChild(tableRow);
    }

    @Override
    protected void closeFile() throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);

        StreamResult streamResult = new StreamResult(fileToAppend);
        transformer.setOutputProperty(OutputKeys.METHOD, "html");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(domSource, streamResult);

        cleanBreakLines(fileToAppend);
    }

    private Element createElement(String name, Object data, Element parent){
		Element retElement = document.createElement(name);
        
        if(data instanceof String) retElement.appendChild(document.createTextNode((String) data));
        else if (data instanceof Integer) retElement.appendChild(document.createTextNode(String.valueOf(data)));
        else if (data instanceof Double) retElement.appendChild(document.createTextNode(String.valueOf(data)));
        
		if (parent != null) parent.appendChild(retElement);
		return retElement;
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
    
}
