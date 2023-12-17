package main.parser;

import main.domain.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HTMLParser extends Parser{
    Document document;

    @Override
    protected void setAssociateInfo() throws Exception{
        document = Jsoup.parse(fileToParse, "UTF-8", "");
        String name = document.select("h1").text().trim();
        String afm = document.select("p").text().replaceAll("[a-zA-Z:]", "").trim();

        associateToParse.setName(name);
        associateToParse.setAfm(afm);
        associateToParse.setPersonalFile(fileToParse);
    }

    @Override
    protected void setAssociateReceipts() throws Exception{
        Element table = document.select("table").get(0);
        Elements rows = table.select("tr");

        for(Element row : rows){
            Elements columns = row.select("td");
            if(columns.size() > 0){
                int receiptID = Integer.parseInt(columns.get(0).text().trim());
                String date = columns.get(1).text().trim();
                ProductType kind = ProductType.valueOf(columns.get(2).text().trim());
                double sales = Double.parseDouble(columns.get(3).text().trim());
                int items = Integer.parseInt(columns.get(4).text().trim());
                String companyName = columns.get(5).text().trim();
                String country = columns.get(6).text().trim();
                String city = columns.get(7).text().trim();
                String street = columns.get(8).text().trim();
                int number = Integer.parseInt(columns.get(9).text().trim());

                Address address = new Address(country, city, street, number);
                Company company = new Company(companyName, address);
                Receipt receipt = new Receipt(receiptID, date, kind, sales, items, company);

                associateToParse.addReceipt(receipt);
            }
        }
    }
}
