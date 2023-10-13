package reporter;

import domain.Agent;

import java.io.File;

import javax.swing.JFileChooser;


public abstract class Reporter {
	protected Agent agent;
	
	public abstract void composeReportFile(String path);
	
	public void saveFile(){
		JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose a directory to save your file: ");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File directory = fileChooser.getSelectedFile();
            String path = directory.getAbsolutePath();
            composeReportFile(path);
        }
	}
}
