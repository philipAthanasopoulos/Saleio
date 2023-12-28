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
	protected File convertedFile = null;
	protected String extension;
	
	public void convertFile(Associate associate , File directory) throws Exception {
		convertedFile = new File(directory, associate.getName() + "." + extension);
		writeAssociateInfo(associate);
		writeReceipts(associate);
		saveFile();
	};

	protected abstract void writeAssociateInfo(Associate associate) throws Exception;

	protected abstract void writeReceipts(Associate associate) throws Exception;

	protected abstract void saveFile() throws Exception;

	public File getConvertedFile() {
		return convertedFile;
	}
	
}
