package main.domain;

import java.io.File;

/**
 * @author Philip Athanasopoulos
 * The Entry class represents a single entry in the GUI application.
 * When the user enters a file, a new entry is created.
 * The entry contains the associate and the file containing their receipts.
 * This way, there can be multiple uploaded receipt files for the same associate.
 * @param associate : the associate
 * @param file : the file with the receipts
 */


public class Entry {
    private Associate associate;
    private File file;

    public Entry(File file) {
        this.associate = associate;
        this.file = file;
    }

    public Associate getAssociate() {
        return associate;
    }

    public File getFile() {
        return file;
    }

}
