package main.parser;

import main.domain.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class HTMLParser extends Parser{

    @Override
    public Associate parseAssociateFromFile(File file) throws Exception {
        Associate resultAssociate = new Associate();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        Map<String, String> associateData = new LinkedHashMap<>(0);
        String line;

        while((line = bufferedReader.readLine()) != null){
            if(line.contains("<td>")){
                String tag = line.replaceAll("<td>", "").replaceAll("</td>", "");
                line = bufferedReader.readLine();
                String data = line.replaceAll("<td>", "").replaceAll("</td>", "");
                associateData.put(tag, data);
            }
        }


        

        //print map
        for(Map.Entry<String, String> entry : associateData.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        //set associate data
        Address address = new Address(
            
        );
        
        
        
        
        return new Associate();

    }
    
}
