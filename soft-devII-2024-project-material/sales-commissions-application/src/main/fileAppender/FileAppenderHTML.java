package main.fileAppender;

import java.io.*;
import java.util.stream.Stream;
import java.util.*;

import main.domain.*;

public class FileAppenderHTML extends FileAppender {

    StringBuilder stringBuilder;
    final String TAB = "\t";

    public FileAppenderHTML(){
        StringBuilder stringBuilder = new StringBuilder(); 
    }

    public void appendReceipt(Receipt receipt, File receiptFile) throws IOException{
        parseFileForAppendToStringBuilder(receiptFile);
        addTableRaw(receipt);
        closeHTML();
        replaceFile(receiptFile);
    }

    private void parseFileForAppendToStringBuilder(File receiptFile) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(receiptFile));
        String line;
        while((line = reader.readLine()) != TAB + "</table>\n") if (line == TAB + TAB + "</tr>\n") reader.mark(800);
        reader.reset();
        for(String iterator : reader.lines().toArray(String[]::new)) stringBuilder.append(iterator);
        reader.close();
    }

    private void addTableRaw(Receipt receipt){
        stringBuilder.append(TAB + TAB + "<tr>\n")
                     .append(TAB + TAB + TAB + "<th>" + receipt.getReceiptID() + "</th>\n")
                     .append(TAB + TAB + TAB + "<th>" + receipt.getPurchaseDate() + "</th>\n")
                     .append(TAB + TAB + TAB + "<th>" + receipt.getProductType() + "</th>\n")
                     .append(TAB + TAB + TAB + "<th>" + receipt.getTotalSales() + "</th>\n")
                     .append(TAB + TAB + TAB + "<th>" + receipt.getNumberOfItems() + "</th>\n")
                     .append(TAB + TAB + TAB + "<th>" + receipt.getCompanyName() + "</th>\n")
                     .append(TAB + TAB + TAB + "<th>" + receipt.getCompanyCountry() + "</th>\n")
                     .append(TAB + TAB + TAB + "<th>" + receipt.getCompanyCity() + "</th>\n")
                     .append(TAB + TAB + TAB + "<th>" + receipt.getCompanyStreet() + "</th>\n")
                     .append(TAB + TAB + TAB + "<th>" + receipt.getCompanyStreetNumber() + "</th>\n")
                     .append(TAB + TAB + "</tr>\n");
    }

    private void closeHTML(){
        stringBuilder.append(TAB + "</table>\n")
                     .append("</body>\n")
                     .append("</html>\n");
    }

    private void replaceFile(File file) throws IOException{
        BufferedWriter writeStream = new BufferedWriter(new FileWriter(file));
        writeStream.write(stringBuilder.toString());
        writeStream.close();
    }
    
}
