package input;

import java.io.File;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



public class XMLInput extends Input {
 
	public XMLInput(File receiptFileXML ){
		inputFile = receiptFileXML;
		
	}
    public void readFile() {
        try {
        	DocumentBuilderFactory docBuilderFactory 
			= DocumentBuilderFactory.newInstance();
        	DocumentBuilder docBuilder
			= docBuilderFactory.newDocumentBuilder();
        	Document doc = docBuilder.parse(inputFile);
        	 
        	doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getElementsByTagName("Agent");
			
        	name = ((Element) nodeLst.item(0)).getElementsByTagName("Name").
			item(0).getChildNodes().item(0).getNodeValue().trim();
			
        	afm = ((Element) nodeLst.item(0)).getElementsByTagName("AFM").
			item(0).getChildNodes().item(0).getNodeValue().trim();
        	addAgent();
        	NodeList receiptsNodeList = ((Element) nodeLst.
			item(0)).getElementsByTagName("Receipt");
			
            int size = receiptsNodeList.getLength();
            for(int i=0; i<size; i++){
            	receiptID = Integer.parseInt(((Element) receiptsNodeList.item(i)).
				getElementsByTagName("ReceiptID").item(0).getChildNodes().item(0).getNodeValue().trim());
            	
            	date = ((Element) receiptsNodeList.item(i)).
				getElementsByTagName("Date").item(0).getChildNodes().item(0).getNodeValue().trim();
				
            	kind = ((Element) receiptsNodeList.item(i))
				.getElementsByTagName("Kind").item(0).getChildNodes().item(0).getNodeValue().trim();
				
            	sales = Double.parseDouble(((Element) receiptsNodeList.item(i)).
				getElementsByTagName("Sales").item(0).getChildNodes().item(0).getNodeValue().trim());
            	
				items = Integer.parseInt(((Element) receiptsNodeList.item(i))
				.getElementsByTagName("Items").item(0).getChildNodes().item(0).getNodeValue().trim());
            	
				companyName = ((Element) receiptsNodeList.item(i)).
				getElementsByTagName("Company").item(0).getChildNodes().item(0).getNodeValue().trim();
            	
				companyCountry = ((Element) receiptsNodeList.item(i)).
				getElementsByTagName("Country").item(0).getChildNodes().item(0).getNodeValue().trim();
            	
				companyCity = ((Element) receiptsNodeList.item(i)).
				getElementsByTagName("City").item(0).getChildNodes().item(0).getNodeValue().trim();
            	
				companyStreet = ((Element) receiptsNodeList.item(i)).
				getElementsByTagName("Street").item(0).getChildNodes().item(0).getNodeValue().trim();
            	
				companyStreetNumber = Integer.parseInt(((Element) receiptsNodeList.item(i)).
				getElementsByTagName("Number").item(0).getChildNodes().item(0).getNodeValue().trim());
            	
				addReceipt();
            }

        	
            
        
            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog
			(null,"Προέκυψε κάποιο πρόβλημα κατά το διάβασμα του αρχείου");
		} 
    }
    
}


