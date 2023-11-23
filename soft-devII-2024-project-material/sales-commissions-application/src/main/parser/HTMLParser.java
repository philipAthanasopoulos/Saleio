package main.parser;

import main.domain.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class HTMLParser extends Parser{
    @Override
    protected void setAssociateInfo(File file, Associate resultAssociate) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        Map<String, String> associateData = new LinkedHashMap<>(0);
        String line;

        while((line = bufferedReader.readLine()) != null){
            if(line.contains("<h1>"))
                associateData.put("Name", line.replaceAll("<h1>", "").replaceAll("</h1>", "").trim());
            if(line.contains("<p>"))
                associateData.put("AFM", line.replaceAll("<p>", "").replaceAll("</p>", "").replaceAll("[a-zA-Z:]","").trim());
        }

        resultAssociate.setName(associateData.get("Name"));
        resultAssociate.setAfm(associateData.get("AFM"));
        resultAssociate.setPersonalFile(file);
        bufferedReader.close();
    };

    //TODO: extract methods , same way as in TXTParser
    @Override
    protected void setAssociateReceipts(File file, Associate resultAssociate) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        Map<String, String> receiptData = new LinkedHashMap<>(0);
        ArrayList<Receipt> receipts = new ArrayList<>(0);
        String line;

        while((line = bufferedReader.readLine()) != null){
            if(line.contains("<th>"))
                while(line.contains("<th>")){
                    String key = line.replaceAll("<th>", "").replaceAll("</th>", "").trim();
                    receiptData.put(key, "");
                    line = bufferedReader.readLine();
                }

                
            if(line.contains("<td>")){
                for(String key : receiptData.keySet()){
                    String value = line.replaceAll("<td>", "").replaceAll("</td>", "").trim();
                    receiptData.put(key, value);
                    line = bufferedReader.readLine();
                }
            

                Address address = new Address(
                    receiptData.get("Country"),
                    receiptData.get("City"),
                    receiptData.get("Street"),
                    Integer.parseInt(receiptData.get("Number"))
                );

                Company company = new Company(
                    receiptData.get("Company"),
                    address
                );

                Receipt receipt = new Receipt(
                    Integer.parseInt(receiptData.get("Receipt ID")),
                    receiptData.get("Date"),
                    ProductType.valueOf(receiptData.get("Kind")),
                    Double.parseDouble(receiptData.get("Sales")),
                    Integer.parseInt(receiptData.get("Items")),
                    company
                );

                receipts.add(receipt);
                clearValues(receiptData);
            }
        }
        bufferedReader.close();
        resultAssociate.setReceipts(receipts);
    }

    public void clearValues(Map<String, String> map){
        for(String key : map.keySet())
            map.put(key, "");
    }
}
