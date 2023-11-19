package main.newReporter;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



public class XMLReporter extends Reporter{

    private Document document;

    @Override
    public void createAndSaveReport(File directory, ArrayList<String> tags, ArrayList<String> values ) throws Exception {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
		document = documentBuilder.newDocument();

        // root element
        Element root = document.createElement("Report");
        document.appendChild(root);

        cleanTagNames(tags);

        for(int i = 0; i < tags.size(); i++){
            createElement(tags.get(i), values.get(i), root);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");

		DOMSource domSource = new DOMSource(document);
		//TODO File is still saved with INCORRECT PATH pls fix so that throws IOException when path is wrong
		StreamResult streamResult = new StreamResult(new File(directory + "/Report.xml"));
		transformer.transform(domSource, streamResult);
    }

    private void cleanTagNames(ArrayList<String> tags){
        for(String tag : tags){
            tag = tag.replaceAll(" ", "");
        }
    }

    private Element createElement(String name, Object data, Element parent){
		Element retElement = document.createElement(name);

        if(data != null)
            if(data instanceof String) retElement.appendChild(document.createTextNode((String) data));
            else if(data instanceof Integer) retElement.appendChild(document.createTextNode(String.valueOf((Integer) data)));
            else if(data instanceof Double) retElement.appendChild(document.createTextNode(String.valueOf((Double) data)));

		if (parent != null) parent.appendChild(retElement);
		return retElement;
	}
}
