package main.converter;

import java.io.*;

import main.domain.*;

import main.parser.*;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;



@SuppressWarnings("all")
public class HTMLConverter extends Converter {

    Document document;
    
    public HTMLConverter() {
        extension = "html";
    }

    @Override
    protected void writeAssociateInfo(Associate associate) throws Exception {
        document = Jsoup.parse(convertedFile, "UTF-8", "");
        document.append("<html><head></head><body></body></html>");
        document.head().append(getStye());
        document.body().append("<h1>" + associate.getName() + "</h1>");
        document.body().append("<p>" + associate.getAfm() + "</p>");
    }

    @Override
    protected void writeReceipts(Associate associate) throws Exception {
        Element table = document.body().append("<table></table>");
        table.append("<tr><th>Receipt ID</th>");
        table.append("<th>Receipt Date</th>");
        table.append("<th>Receipt Kind</th>");
        table.append("<th>Receipt Amount</th>");
        table.append("<th>Receipt Company</th>");
        table.append("<th>Receipt Country</th>");
        table.append("<th>Receipt City</th>");
        table.append("<th>Receipt Street</th>");
        table.append("<th>Receipt Number</th></tr>");


        for (Receipt receipt : associate.getReceipts()) {
            table.append("<tr><td>" + receipt.getReceiptID() + "</td>");
            table.append("<td>" + receipt.getPurchaseDate() + "</td>");
            table.append("<td>" + receipt.getProductType() + "</td>");
            table.append("<td>" + receipt.getTotalSales() + "</td>");
            table.append("<td>" + receipt.getCompanyName() + "</td>");
            table.append("<td>" + receipt.getCompanyCountry() + "</td>");
            table.append("<td>" + receipt.getCompanyCity() + "</td>");
            table.append("<td>" + receipt.getCompanyStreet() + "</td>");
            table.append("<td>" + receipt.getCompanyStreetNumber() + "</td></tr>");
        }
    }

    @Override
    protected void saveFile() throws Exception {
        FileWriter writer = new FileWriter(convertedFile);
        writer.write(document.outerHtml());
        writer.close();
    }


    private String getStye(){
        return "<style>table, th, td {border: 1px solid black;}</style>";
    }
   
}
