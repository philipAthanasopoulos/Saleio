package main.reporter;

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
    private DocumentBuilder documentBuilder;
    private StreamResult streamResult;

    public XMLReporter() {
        this.fileExtension = "xml";
    }

    @Override
    protected void openFile() throws Exception {
        streamResult = new StreamResult(reportFile);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilder = documentBuilderFactory.newDocumentBuilder();
        document = documentBuilder.newDocument();
    }

    @Override
    protected void writeReport(ArrayList<ArrayList<String>> data) throws Exception {
        cleanData(data);

        Element rootElement = createElement("Report", null, null);
        document.appendChild(rootElement);

        for (ArrayList<String> row : data) {
            createElement(row.get(0), row, rootElement);
        }
    }

    @Override
    protected void closeFile() throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(domSource, streamResult);
    }

    private void cleanData(ArrayList<ArrayList<String>> data){
        for(ArrayList<String> row : data){
            if (!row.isEmpty()) {
                String firstCell = row.get(0);
                firstCell = firstCell.replaceAll(" ", "");
                row.set(0, firstCell);
                System.out.println(firstCell);
            }
        }
    }

    private Element createElement(String name, ArrayList<String> row, Element parent){
		Element retElement = document.createElement(name);
        if(row == null && parent == null) return retElement;
        
        row.remove(0);
        String content = "";
        for(String cell: row) content += cell + " ";
        
        retElement.appendChild(document.createTextNode(content));
		parent.appendChild(retElement);
		return retElement;
	}
}
