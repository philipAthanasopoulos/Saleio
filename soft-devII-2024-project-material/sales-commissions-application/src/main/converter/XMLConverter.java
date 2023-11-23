package main.converter;

import java.io.File;

import main.domain.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import main.domain.Associate;

public class XMLConverter extends Converter {

	Document document;
		
	public XMLConverter(Associate associate){
		this.extension = "xml";
	}	

	@Override
	protected void writeAssociateInfo(Associate associate) throws Exception {
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
		document = documentBuilder.newDocument();
		Element agentElem = document.getDocumentElement();
		createElement("Name", associate.getName(), agentElem);
		createElement("AFM", associate.getAfm(), agentElem);
	}

	@Override
	protected void writeReceipts(Associate associate) throws Exception {
		Element agentElem = document.getDocumentElement();
		Element receipts = createElement("Receipts", null, agentElem);
		
		for (Receipt receipt : associate.getReceipts()){
			writeReceipt(receipt, receipts);
		}
	}

	@Override
	protected void saveFile() throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //TODO: check if this is needed
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");

		DOMSource domSource = new DOMSource(document);
		//TODO File is still saved with INCORRECT PATH pls fix so that throws IOException when path is wrong
		StreamResult streamResult = new StreamResult(convertedFile);
		transformer.transform(domSource, streamResult);
	}

	// @Override
	// public File convertFile(String path) throws Exception {
	// 	DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
	// 	DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	// 	document = documentBuilder.newDocument();

	// 	// root element
	// 	Element agentElem = document.createElement("Agent");
	// 	document.appendChild(agentElem);
		
	// 	createElement("Name", associate.getName(), agentElem);
	// 	createElement("AFM", associate.getAfm(), agentElem);
		
	// 	Element receipts = createElement("Receipts", null, agentElem);
		
	// 	for (Receipt receipt : associate.getReceipts()){
	// 		writeReceipt(receipt, receipts);
	// 	}
		
	// 	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	// 	Transformer transformer = transformerFactory.newTransformer();
	// 	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	// 	transformer.setOutputProperty(OutputKeys.METHOD, "xml");

	// 	DOMSource domSource = new DOMSource(document);
	// 	//TODO File is still saved with INCORRECT PATH pls fix so that throws IOException when path is wrong
	// 	File resultFile = new File(path + "/Report.xml");
	// 	StreamResult streamResult = new StreamResult(resultFile);
	// 	transformer.transform(domSource, streamResult);
			
	// 	return resultFile;
	// }

	private void writeReceipt(Receipt receipt, Element parent){
			Element receiptElement = createElement("Receipt", null, parent);

			createElement("ReceiptID", receipt.getReceiptID(), receiptElement);
			createElement("Date", receipt.getPurchaseDate(), receiptElement);
			createElement("Kind", receipt.getProductType().name(), receiptElement);
			createElement("Sales", receipt.getTotalSales(), receiptElement);
			createElement("Items", receipt.getNumberOfItems(), receiptElement);
			createElement("Company", receipt.getCompanyName(), receiptElement);
			createElement("Country", receipt.getCompanyCountry(), receiptElement);
			createElement("City", receipt.getCompanyCity(), receiptElement);
			createElement("Street", receipt.getCompanyStreet(), receiptElement);
			createElement("Number", receipt.getCompanyStreetNumber(), receiptElement);
	}

	private Element createElement(String name, Object data, Element parent){
		Element retElement = document.createElement(name);

		if(data instanceof String) retElement.appendChild(document.createTextNode((String) data));
		else if(data instanceof Integer) retElement.appendChild(document.createTextNode(String.valueOf((Integer) data)));
		else if(data instanceof Double) retElement.appendChild(document.createTextNode(String.valueOf((Double) data)));
		else retElement.appendChild(document.createTextNode(""));

		if (parent != null) parent.appendChild(retElement);
		return retElement;
	}
}

