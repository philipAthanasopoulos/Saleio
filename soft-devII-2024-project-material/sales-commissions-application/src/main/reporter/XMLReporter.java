package main.reporter;

import java.io.File;

import main.domain.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.swing.JOptionPane;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import main.domain.Associate;

public class XMLReporter extends Reporter {
		
	public XMLReporter(Associate associate){
		this.associate = associate;
	}	

	@Override
	public void composeReportFile(String path) {
		// TODO Auto-generated method stub
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			// root element
			Element agentElem = document.createElement("Agent");
			document.appendChild(agentElem);
			
			Element name = document.createElement("Name");
			name.appendChild(document.createTextNode(associate.getName()));
			agentElem.appendChild(name);
			
			Element afm = document.createElement("AFM");
			afm.appendChild(document.createTextNode(associate.getAfm()));
			agentElem.appendChild(afm);
			
			Element Receipts = document.createElement("Receipts");
			agentElem.appendChild(Receipts);
			
			for (Receipt receipt : associate.getReceipts()){
				Element receiptElement = document.createElement("Receipt");
				Receipts.appendChild(receiptElement);

				Element receiptId = document.createElement("ReceiptID");
				receiptId.appendChild(document.createTextNode(String.valueOf(receipt.getReceiptID())));
				receiptElement.appendChild(receiptId);

				Element date = document.createElement("Date");
				date.appendChild(document.createTextNode(receipt.getPurchaseDate()));
				receiptElement.appendChild(date);

				Element kind = document.createElement("Kind");
				kind.appendChild(document.createTextNode(receipt.productTypeToString()));
				receiptElement.appendChild(kind);

				Element sales = document.createElement("Sales");
				sales.appendChild(document.createTextNode(String.valueOf(receipt.getTotalSales())));
				receiptElement.appendChild(sales);

				Element items = document.createElement("Items");
				items.appendChild(document.createTextNode(String.valueOf(receipt.getNumberOfItems())));
				receiptElement.appendChild(items);

				String companyName = receipt.getCompany().getCompanyName();
				Element companyNameElement = document.createElement("Company");
				companyNameElement.appendChild(document.createTextNode(companyName));
				receiptElement.appendChild(companyNameElement);

				Address companyAddress = receipt.getCompany().getCompanyAddress();
				Element country = document.createElement("Country");
				country.appendChild(document.createTextNode(companyAddress.getCountry()));
				receiptElement.appendChild(country);

				Element city = document.createElement("City");
				city.appendChild(document.createTextNode(companyAddress.getCity()));
				receiptElement.appendChild(city);

				Element street = document.createElement("Street");
				street.appendChild(document.createTextNode(companyAddress.getStreet()));
				receiptElement.appendChild(street);

				Element streetNumber = document.createElement("Number");
				streetNumber.appendChild(document.createTextNode(String.valueOf(companyAddress.getStreetNumber())));
				receiptElement.appendChild(streetNumber);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");

			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(path + "/Report.xml"));
			transformer.transform(domSource, streamResult);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e.toString());
			JOptionPane.showMessageDialog(null, "Πρόβλημα κατά την αποθήκευση του αρχείου", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
		}
	}
}

