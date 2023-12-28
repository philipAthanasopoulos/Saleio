package main.fileAppender;


import java.io.BufferedWriter;
import java.io.FileWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

public class FileAppenderHTML extends FileAppender {
    
    Document document;
    BufferedWriter writer;
    
    @Override
    protected void openFile() throws Exception {
        document = Jsoup.parse(fileToAppend, "UTF-8", "");
    }
    
    @Override
    protected void writeReceipt() throws Exception {
        Element table = document.select("table").first();
        System.out.println(table);
        Element newRow = new Element(Tag.valueOf("tr"), "");
        
        newRow.appendElement("td").text(String.valueOf(receiptToAppend.getReceiptID()));
        newRow.appendElement("td").text(receiptToAppend.getPurchaseDate());
        newRow.appendElement("td").text(String.valueOf(receiptToAppend.getProductType()));
        newRow.appendElement("td").text(String.valueOf(receiptToAppend.getTotalSales()));
        newRow.appendElement("td").text(String.valueOf(receiptToAppend.getNumberOfItems()));
        newRow.appendElement("td").text(String.valueOf(receiptToAppend.getCompanyName()));
        newRow.appendElement("td").text(String.valueOf(receiptToAppend.getCompanyCity()));
        newRow.appendElement("td").text(String.valueOf(receiptToAppend.getCompanyStreet()));
        newRow.appendElement("td").text(String.valueOf(receiptToAppend.getCompanyStreetNumber()));
        
        table.append(newRow.toString());
        
    }
    
    @Override
    protected void closeFile() throws Exception {
        writer = new BufferedWriter(new FileWriter(fileToAppend));
        writer.write(document.outerHtml());
        writer.close();
    }
    
}
