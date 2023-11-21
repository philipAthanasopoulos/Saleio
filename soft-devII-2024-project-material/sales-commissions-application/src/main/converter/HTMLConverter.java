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
        stringBuilder.append("<!DOCTYPE html>\n")
                     .append("<html lang=\"en\">\n");
        addHead("Receipts");
        addBody();
        stringBuilder.append("</html>\n");

        File resultFile = exportNewFile(path);
        return resultFile;
    }

    private void addHead(String title){
        stringBuilder.append("<head>\n")
                     .append(TAB + "<meta charset=\"UTF-8\">\n")
                     .append(TAB + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n")
                     .append(TAB + "<title>" + title + "</title>\n");
        addStyle();
        stringBuilder.append("</head>");
    }

    private void addStyle(){
        stringBuilder.append(TAB + "<style>\n")
                     .append(TAB + TAB + "table, th, td {\n")
                     .append(TAB + TAB + TAB + "border: 1px solid black;\n")
                     .append(TAB + TAB + "}\n")
                     .append(TAB + TAB + "table {\n")
                     .append(TAB + TAB + TAB + "border-collapse: collapse;\n")
                     .append(TAB + TAB + "}\n")
                     .append(TAB + TAB + "th, td {\n")
                     .append(TAB + "</style>\n")
                     .append(TAB + TAB + TAB + "padding: 5px;\n")
                     .append(TAB + TAB + "}\n");
    }

    private void addBody(){
        String name = associate.getName();
        stringBuilder.append("<body>\n")
                     .append(TAB + "<h1>" + name + "</h1>\n")
                     .append(TAB + "<p>" + "AFM: " + name + "</p>\n");
        addTable();
        stringBuilder.append("</body>\n");
    }

    private void addTable() {
        stringBuilder.append(TAB + "<table border=\"1\">\n");
        addTableHeaders();
        for (Receipt receipt : associate.getReceipts()) addTableRaw(receipt);
        stringBuilder.append(TAB + "</table>\n");
    }

    private void addTableHeaders(){
        stringBuilder.append(TAB + TAB + "<tr>\n")
                     .append(TAB + TAB + TAB + "<th>Receipt ID</th>\n")
                     .append(TAB + TAB + TAB + "<th>Date</th>\n")
                     .append(TAB + TAB + TAB + "<th>Kind</th>\n")
                     .append(TAB + TAB + TAB + "<th>Sales</th>\n")
                     .append(TAB + TAB + TAB + "<th>Items</th>\n")
                     .append(TAB + TAB + TAB + "<th>Company</th>\n")
                     .append(TAB + TAB + TAB + "<th>Country</th>\n")
                     .append(TAB + TAB + TAB + "<th>City</th>\n")
                     .append(TAB + TAB + TAB + "<th>Street</th>\n")
                     .append(TAB + TAB + TAB + "<th>Number</th>\n")
                     .append(TAB + TAB + "</tr>\n");
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

    private File exportNewFile(String path) throws IOException{
        File resultFile = new File(path + "/Report.html");
        BufferedWriter writeStream = new BufferedWriter(new FileWriter(resultFile));
        writeStream.write(stringBuilder.toString());
        writeStream.close();
        return resultFile;
    }

    public static void main(String[] args){
        ParserFactory parserFactory = new ParserFactory();
        Parser parser = parserFactory.getParser("txt");
        String directory = System.getProperty("user.dir");
        Associate associate;

        try{
            associate = parser.parseAssociateFromFile(new File(directory + "\\soft-devII-2024-project-material\\test_input_files\\test-case-2-TXT.txt"));
        }catch(Exception e){
            e.printStackTrace();
            return;
        }

        ConverterFactory converterFactory = new ConverterFactory();
        Converter htmlConverter = converterFactory.getConverter("html", associate);

        try{
            htmlConverter.convertFile(directory+"\\out");
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
