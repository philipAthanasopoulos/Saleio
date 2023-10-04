package data;

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
import org.w3c.dom.Node;

public class FileAppenderXML  extends FileAppender{

public  void setFileToAppend(File fileToAppend) {
		
		this.fileToAppend = fileToAppend;
		
	}
	public void appendFile(){

		try{
		
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(fileToAppend);
		
			Node agent = doc.getFirstChild();

			Element receiptElem = doc.createElement("Receipt");
			agent.appendChild(receiptElem);		
		
			Element receiptIDElem = doc.createElement("ReceiptID");
			receiptIDElem.appendChild(doc.createTextNode(receiptID));
			receiptElem.appendChild(receiptIDElem);

	       	Element dateElem = doc.createElement("Date");
	       	dateElem.appendChild(doc.createTextNode(date));
	       	receiptElem.appendChild(dateElem);
       	
	       	Element kindElem = doc.createElement("Kind");
	       	kindElem.appendChild(doc.createTextNode(kind));
	       	receiptElem.appendChild(kindElem);
	       	
	       	Element salesElem = doc.createElement("Sales");
	       	salesElem.appendChild(doc.createTextNode(sales));
	       	receiptElem.appendChild(salesElem);
	       	
	       	Element itemsElem = doc.createElement("Items");
	       	itemsElem.appendChild(doc.createTextNode(items));
	       	receiptElem.appendChild(itemsElem);
	       	
	       	Element companyElem = doc.createElement("Company");
			companyElem.appendChild(doc.createTextNode(company));
			receiptElem.appendChild(companyElem);
	       	
	       	Element countryElem = doc.createElement("Country");
	       	countryElem.appendChild(doc.createTextNode(country));
	       	receiptElem.appendChild(countryElem);
	       	
	       	Element cityElem = doc.createElement("City");
	       	cityElem.appendChild(doc.createTextNode(city));
	       	receiptElem.appendChild(cityElem);
	       	
	       	Element streetElem = doc.createElement("Street");
	       	streetElem.appendChild(doc.createTextNode(street));
	       	receiptElem.appendChild(streetElem);
	       	
	       	Element numberElem = doc.createElement("Number");
	       	numberElem.appendChild(doc.createTextNode(number));
	       	receiptElem.appendChild(numberElem);
	    
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	   	 	transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(fileToAppend);
			transformer.transform(source, result);

		}catch (Exception e){
			e.printStackTrace();
		}
	}
		
	public void setReceiptID(String receiptID) {
		this.receiptID = receiptID;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public void setSales(String sales) {
		this.sales = sales;
	}


	public void setItems(String items) {
		this.items = items;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public void setStreet(String street) {
		this.street = street;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
