package main.parser;

import main.domain.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class HTMLParser extends Parser{

    private int RECEIPT_DATA_SIZE = 10;

    @Override
    public Associate parseAssociateFromFile(File file) throws Exception {
        Associate resultAssociate = new Associate();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        Map<String, String> associateData = new LinkedHashMap<>(0);
        Map<String, String> receiptData = new LinkedHashMap<>(0);
        ArrayList<Receipt> receipts = new ArrayList<>(0);
        String line;


        while((line = bufferedReader.readLine()) != null){

                if(line.contains("<h1>"))
                    associateData.put("Name", line.replaceAll("<h1>", "").replaceAll("</h1>", ""));
                if(line.contains("<p>"))
                    associateData.put("AFM", line.replaceAll("<p>", "").replaceAll("</p>", ""));
                if(line.contains("<th>"))
                    while(line.contains("<th>")){
                        String key = line.replaceAll("<th>", "").replaceAll("</th>", "");
                        receiptData.put(key, "");
                        line = bufferedReader.readLine();
                    }

                    
                    if(line.contains("<td>")){
                        for(int i = 0; i < RECEIPT_DATA_SIZE; i++){
                            String value = (line.replaceAll("<td>", "").replaceAll("</td>", ""));
                            receiptData.put(receiptData.keySet().toArray()[i].toString(), value);
                            line = bufferedReader.readLine();
                            System.out.println(value);
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
                    receiptData.clear();
                }
        }
        
        resultAssociate = new Associate(
            associateData.get("Name"),
            associateData.get("AFM"),
            receipts,
            file
        );
        
        bufferedReader.close();
        return resultAssociate;
    }
}
