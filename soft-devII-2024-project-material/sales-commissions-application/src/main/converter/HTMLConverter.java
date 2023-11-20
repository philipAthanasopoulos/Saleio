package main.converter;

import java.io.*;

import main.domain.*;

import main.parser.*;

public class HTMLConverter extends Converter {

    final String TAB = "\t";

    StringBuilder stringBuilder; 

    public HTMLConverter(Associate associate) {
        this.associate = associate;

        stringBuilder = new StringBuilder();
    }


    public File convertFile(String path) throws IOException{

        stringBuilder.append("<!DOCTYPE html>\n");
        stringBuilder.append("<html lang=\"en\">\n");

        writeHead("Receipts");

        writeBody();

        stringBuilder.append("</html>\n");

        File resultFile = exportNewFile(path);
        return resultFile;
    }

    private void writeHead(String title){

        stringBuilder.append("<head>\n");
        stringBuilder.append(TAB + "<meta charset=\"UTF-8\">\n");
        stringBuilder.append(TAB + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
        stringBuilder.append(TAB + "<title>" + title + "</title>\n");

        writeStyle();

        stringBuilder.append("</head>");
    }

    private void writeStyle(){
        stringBuilder.append(TAB + "<style>\n");
        stringBuilder.append(TAB + TAB + "table, th, td {\n");
        stringBuilder.append(TAB + TAB + TAB + "border: 1px solid black;\n");
        stringBuilder.append(TAB + TAB + "}\n");
        stringBuilder.append(TAB + TAB + "table {\n");
        stringBuilder.append(TAB + TAB + TAB + "border-collapse: collapse;\n");
        stringBuilder.append(TAB + TAB + "}\n");
        stringBuilder.append(TAB + TAB + "th, td {\n");
        stringBuilder.append(TAB + TAB + TAB + "padding: 5px;\n");
        stringBuilder.append(TAB + TAB + "}\n");
        stringBuilder.append(TAB + "</style>\n");
    }

    private void writeBody(){
        stringBuilder.append("<body>\n");

        stringBuilder.append(TAB + "<h1>" + associate.getName() + "</h1>\n");
        stringBuilder.append(TAB + "<p>" + "AFM: " + associate.getAfm() + "</p>\n");

        writeTable();


        stringBuilder.append("</body>\n");
    }

    private void writeTable() {
        stringBuilder.append(TAB + "<table border=\"1\">\n");

        writeTableHeaders();

        for (Receipt receipt : associate.getReceipts()){
            writeTableRaw(receipt);
        }

        stringBuilder.append(TAB + "</table>\n");
    }

    private void writeTableHeaders(){
        stringBuilder.append(TAB + TAB + "<tr>\n");

        stringBuilder.append(TAB + TAB + TAB + "<th>Receipt ID</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>Date</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>Kind</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>Sales</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>Items</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>Company</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>Country</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>City</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>Street</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>Number</th>\n");

        stringBuilder.append(TAB + TAB + "</tr>\n");
    }

    private void writeTableRaw(Receipt receipt){
        stringBuilder.append(TAB + TAB + "<tr>\n");

        stringBuilder.append(TAB + TAB + TAB + "<th>" + receipt.getReceiptID() + "</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>" + receipt.getPurchaseDate() + "</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>" + receipt.getProductType() + "</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>" + receipt.getTotalSales() + "</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>" + receipt.getNumberOfItems() + "</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>" + receipt.getCompanyName() + "</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>" + receipt.getCompanyCountry() + "</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>" + receipt.getCompanyCity() + "</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>" + receipt.getCompanyStreet() + "</th>\n");
        stringBuilder.append(TAB + TAB + TAB + "<th>" + receipt.getCompanyStreetNumber() + "</th>\n");

        stringBuilder.append(TAB + TAB + "</tr>\n");
    }

    private File exportNewFile(String path) throws IOException{

        File resultFile = new File(path + "/Report.html");
        BufferedWriter writeStream = new BufferedWriter(new FileWriter(resultFile));

        writeStream.write(stringBuilder.toString());

        writeStream.close();

        return resultFile;
    }


    public static void main(String[] args){
        ParserFactory pf = new ParserFactory();
        Parser p = pf.getParser("txt");

        String dir = System.getProperty("user.dir");
        Associate tester;

        try{
            tester = p.parseAssociateFromFile(new File(dir + "\\soft-devII-2024-project-material\\test_input_files\\test-case-2-TXT.txt"));
        }catch(Exception e){
            e.printStackTrace();
            return;
        }

        ConverterFactory rf = new ConverterFactory();

        Converter html = rf.getConverter("html", tester);

        try{
            html.convertFile(dir+"\\out");
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
