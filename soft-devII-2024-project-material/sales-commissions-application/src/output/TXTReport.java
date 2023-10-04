package output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import data.Agent;


public class TXTReport extends Report{

	
	public TXTReport(Agent a){
		agent = a;
	}
	
	
	public void saveFile() {
        BufferedWriter bufferedWriter = null;
        try{
        	String fullPathName =  "/users/Nick/Desktop/Reports/" + agent.getAfm() + "_SALES.txt";
        	bufferedWriter = new BufferedWriter(new FileWriter(new File(fullPathName)));
            
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


        }catch (IOException ex){
			JOptionPane.showMessageDialog(null,"Υπήρξε κάποιο πρόβλημα κατά την αποθήκευση του αρχείου");

        }
		
	}

}
