package main.reporter;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import main.domain.Associate;

public class TXTReporter extends Reporter {
	
	public TXTReporter(Associate associate){
		this.associate = associate;
	}

    @Override
    public void composeReportFile(String path){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + "/Report.txt"));
            bufferedWriter.write(String.format("Name: %s%n", associate.getName()));
            bufferedWriter.write(String.format("AFM: %s%n%n%n", associate.getAfm()));
            bufferedWriter.write(String.format("Total Sales: %.2f%n", associate.calculateTotalSales()));
            bufferedWriter.write(String.format("Trousers Sales: %.2f%n", associate.calculateTrouserSales()));
            bufferedWriter.write(String.format("Skirts Sales: %.2f%n", associate.calculateSkirtsSales()));
            bufferedWriter.write(String.format("Shirts Sales: %.2f%n", associate.calculateShirtsSales()));
            bufferedWriter.write(String.format("Coats Sales: %.2f%n", associate.calculateCoatsSales()));
            bufferedWriter.write(String.format("Commission: %.2f%n", associate.calculateCommission()));
            bufferedWriter.close();
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Πρόβλημα κατά την αποθήκευση του αρχείου", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }
    }
}
