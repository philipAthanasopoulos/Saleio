package main.reporter;

import java.io.File;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XMLReporter extends Reporter{

    private Document document;

    @Override
    public File generateReport(File directory, ArrayList<String> tags, ArrayList<String> values ) throws Exception {
        File resultFile = new File(directory + "/Report.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.newDocument();

        Element rootElement = createElement("Report", null, null);
        document.appendChild(rootElement);
        
        cleanTagNames(tags);
        for(String tag : tags){
            createElement(tag, values.get(tags.indexOf(tag)), rootElement);
        }

        getStreamResult(resultFile);

        return resultFile;
    }

    private void getStreamResult(File resultFile)
            throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(resultFile);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(domSource, streamResult);
    }

    private void cleanTagNames(ArrayList<String> tags){
        for(int i = 0; i < tags.size(); i++){
            String tag = tags.get(i);
            tag = tag.trim().replaceAll(" ", "_");
            tags.set(i, tag);
        }
    }

    private Element createElement(String name, Object data, Element parent){
		Element retElement = document.createElement(name);
        if(data == null && parent == null) return retElement;
        
        if(data instanceof String) retElement.appendChild(document.createTextNode((String) data));
        else if(data instanceof Integer) retElement.appendChild(document.createTextNode(String.valueOf((Integer) data)));
        else if(data instanceof Double) retElement.appendChild(document.createTextNode(String.valueOf((Double) data)));

		parent.appendChild(retElement);
		return retElement;
	}
}
