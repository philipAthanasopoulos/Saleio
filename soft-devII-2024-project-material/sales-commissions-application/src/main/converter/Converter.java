package main.converter;

import java.io.File;

import main.domain.Associate;

/**
 * @author Philip Athanasopoulos
 * The Converter class is an abstract class that is used to compose reports
 * for the sales of an associate in various formats (txt, xml, etc.).
 * @param associate The associate whose sales are to be reported.
 */

public abstract class Converter {
	protected Associate associate;
	
	public abstract File convertFile(String path) throws Exception;
	
	public void saveFile() throws Exception{

        //TODO : Get gui outttt
        
		// JFileChooser fileChooser = new JFileChooser();
        // fileChooser.setDialogTitle("Choose a directory to save your file: ");
        // fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        // int userSelection = fileChooser.showSaveDialog(null);

        // if (userSelection == JFileChooser.APPROVE_OPTION) {
        //     File directory = fileChooser.getSelectedFile();
        //     String path = directory.getAbsolutePath();
        //     composeReportFile(path);
        // }
	}

    public static void main(String[] args){
        Converter rep = new TXTConverter(new Associate());
        try {
            rep.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
