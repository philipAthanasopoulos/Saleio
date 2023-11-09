package main.reporter;

import java.io.File;
import java.io.IOException;

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

public class XMLReporter extends Reporter {

	Document document;
		
	public XMLReporter(Associate associate){
		this.associate = associate;
		document = null;
	}	

	@Override
	public void composeReportFile(String path) throws IOException{
		
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			document = documentBuilder.newDocument();

			// root element
			Element agentElem = document.createElement("Agent");
			document.appendChild(agentElem);
			
			createElement("Name", associate.getName(), agentElem);
			
			createElement("AFM", associate.getAfm(), agentElem);
			
			Element receipts = createElement("Receipts", null, agentElem);
			
			for (Receipt receipt : associate.getReceipts()){

				Element receiptElement = createElement("Receipt", null, receipts);

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
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");

			DOMSource domSource = new DOMSource(document);
			//TODO File is still saved with INCORRECT PATH pls fix so that throws IOException when path is wrong
			StreamResult streamResult = new StreamResult(new File(path + "/Report.xml"));
			transformer.transform(domSource, streamResult);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.toString());

			//TODO : Move to gui
			//JOptionPane.showMessageDialog(null, "Πρόβλημα κατά την αποθήκευση του αρχείου/n"+e.toString(), "Σφάλμα", JOptionPane.ERROR_MESSAGE);
		}
	}

	private Element createElement(String name, String data, Element parent){
		Element retElement = document.createElement(name);
		if (data != null) retElement.appendChild(document.createTextNode(data));
		if (parent != null) parent.appendChild(retElement);
		return retElement;
	}

	private Element createElement(String name, int data, Element parent){
		Element retElement = document.createElement(name);
		retElement.appendChild(document.createTextNode(String.valueOf(data)));
		if (parent != null) parent.appendChild(retElement);
		return retElement;
	}

	private Element createElement(String name, double data, Element parent){
		Element retElement = document.createElement(name);
		retElement.appendChild(document.createTextNode(String.valueOf(data)));
		if (parent != null) parent.appendChild(retElement);
		return retElement;
	}
}

