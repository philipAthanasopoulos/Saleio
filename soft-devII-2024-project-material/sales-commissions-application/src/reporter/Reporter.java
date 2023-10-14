package reporter;

import domain.Associate;

import java.io.File;

import javax.swing.JFileChooser;

/**
 * @author Philip Athanasopoulos
 * The Reporter class is an abstract class that is used to compose reports
 * for the sales of an associate in various formats (txt, xml, etc.).
 * @param associate The associate whose sales are to be reported.
 */

public abstract class Reporter {
	protected Associate associate;
	
	public abstract void composeReportFile(String path); // maybe a better name?
	
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
