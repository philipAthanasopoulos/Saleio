package reporter;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import domain.Associate;

public class TXTReporter extends Reporter {
	
	public TXTReporter(Associate associate){
		this.associate = associate;
	}

    @Override
    public void composeReportFile(String path){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + "/Report.txt"));
            bufferedWriter.write("Name: " + associate.getName());
            bufferedWriter.newLine();
    
            bufferedWriter.write("AFM: " + associate.getAfm());
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.newLine();
    
            bufferedWriter.write("Total Sales: " + associate.calculateTotalSales());
            bufferedWriter.newLine();
    
            bufferedWriter.write("Trousers Sales: " + associate.calculateTrouserSales());
            bufferedWriter.newLine();
    
            bufferedWriter.write("Skirts Sales: " + associate.calculateSkirtsSales());
            bufferedWriter.newLine();
    
            bufferedWriter.write("Shirts Sales: " + associate.calculateShirtsSales());
            bufferedWriter.newLine();
            
            bufferedWriter.write("Coats Sales: " + associate.calculateCoatsSales());
            bufferedWriter.newLine();
    
            bufferedWriter.write("Commission: " + associate.calculateCommission());
            
            bufferedWriter.close();
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null, "Πρόβλημα κατά την αποθήκευση του αρχείου", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }
    }
}
