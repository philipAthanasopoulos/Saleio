package main.reporter;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import main.domain.*;

public class TXTReporter extends Reporter {
	
	public TXTReporter(Associate associate){
		this.associate = associate;
	}

    @Override
    public void composeReportFile(String path){
        try {
            BufferedWriter writeStream = new BufferedWriter(new FileWriter(path + "/Report.txt"));

            writeStream.write(String.format("Name: %s%n", associate.getName()));
            writeStream.write(String.format("AFM: %s%n%n", associate.getAfm()));
            writeStream.write(String.format("Receipts: %n%n"));
            
            for(Receipt receipt : associate.getReceipts()){
                writeStream.write(receipt.toString()+"\n");
            }
            writeStream.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Πρόβλημα κατά την αποθήκευση του αρχείου", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }
    }
}
