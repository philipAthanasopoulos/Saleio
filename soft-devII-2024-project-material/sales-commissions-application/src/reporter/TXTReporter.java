package reporter;

import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JOptionPane;

import domain.Agent;


public class TXTReporter extends Reporter {
	
	public TXTReporter(Agent agent){
		this.agent = agent;
	}

    @Override
    public void composeReportFile(String path){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + "/Report.txt"));
            bufferedWriter.write("Name: " + agent.getName()); 
            bufferedWriter.newLine();
    
            bufferedWriter.write("AFM: " + agent.getAfm());
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.newLine();
    
            bufferedWriter.write("Total Sales: " + agent.calculateTotalSales());
            bufferedWriter.newLine();
    
            bufferedWriter.write("Trousers Sales: " + agent.calculateTrouserSales());
            bufferedWriter.newLine();
    
            bufferedWriter.write("Skirts Sales: " + agent.calculateSkirtsSales());
            bufferedWriter.newLine();
    
            bufferedWriter.write("Shirts Sales: " + agent.calculateShirtsSales());
            bufferedWriter.newLine();
            
            bufferedWriter.write("Coats Sales: " + agent.calculateCoatsSales());
            bufferedWriter.newLine();
    
            bufferedWriter.write("Commission: " + agent.calculateCommission());
            
            bufferedWriter.close();
        } catch (Exception e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null,"Πρόβλημα κατά την αποθήκευση του αρχείου");
        }
    }
}
