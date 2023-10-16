package main.reporter;

import java.io.File;

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
			Element agentElem = document.createElement("Associate");
			document.appendChild(agentElem);
			
			Element name = document.createElement("Name");
			name.appendChild(document.createTextNode(associate.getName()));
			agentElem.appendChild(name);
			
			Element afm = document.createElement("AFM");
			afm.appendChild(document.createTextNode(associate.getAfm()));
			agentElem.appendChild(afm);
			
			Element totalSales = document.createElement("TotalSales");
			totalSales.appendChild(document.createTextNode(Double.toString(associate.calculateTotalSales())));
			agentElem.appendChild(totalSales);
			
			Element trouserSales = document.createElement("TrouserSales");
			trouserSales.appendChild(document.createTextNode(Double.toString(associate.calculateTrouserSales())));
			agentElem.appendChild(trouserSales);
			
			Element skirtsSales = document.createElement("SkirtsSales");
			skirtsSales.appendChild(document.createTextNode(Double.toString(associate.calculateSkirtsSales())));
			agentElem.appendChild(skirtsSales);
			
			Element shirtsSales = document.createElement("ShirtsSales");
			shirtsSales.appendChild(document.createTextNode(Double.toString(associate.calculateShirtsSales())));
			agentElem.appendChild(shirtsSales);
			
			Element coatsSales = document.createElement("CoatsSales");
			coatsSales.appendChild(document.createTextNode(Double.toString(associate.calculateCoatsSales())));
			agentElem.appendChild(coatsSales);
			
			Element commission = document.createElement("Commission");
			commission.appendChild(document.createTextNode(Double.toString(associate.calculateCommission())));
			agentElem.appendChild(commission);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(new File(path + "/Report.xml"));
			transformer.transform(domSource, streamResult);
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Πρόβλημα κατά την αποθήκευση του αρχείου", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
		}
	}
}
