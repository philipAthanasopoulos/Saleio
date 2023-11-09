package main.reporter;

import main.domain.Associate;

import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * @author Philip Athanasopoulos
 * The Reporter class is an abstract class that is used to compose reports
 * for the sales of an associate in various formats (txt, xml, etc.).
 * @param associate The associate whose sales are to be reported.
 */

public abstract class Reporter {
	protected Associate associate;
	
	public abstract void composeReportFile(String path) throws IOException; // maybe a better name?
	
	public void saveFile(){

        //TODO : Get gui outttt
        
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a directory to save your file: ");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File directory = fileChooser.getSelectedFile();
            String path = directory.getAbsolutePath();
            try {
            	composeReportFile(path);
            }catch(IOException e) {
            	//TODO Do smth when gui is out of here
            	JOptionPane.showMessageDialog(null, "Πρόβλημα κατά την αποθήκευση του αρχείου", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
            	e.printStackTrace();
            }
        }
	}

    public static void main(String[] args){
        Reporter rep = new TXTReporter(new Associate());
        rep.saveFile();
    }
}
