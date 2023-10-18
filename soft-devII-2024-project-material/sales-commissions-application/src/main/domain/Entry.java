package main.domain;

import java.io.File;

/**
 * @author Philip Athanasopoulos
 * The Entry class represents a single entry in the GUI application.
 * When the user enters a file, a new entry is created.
 * The entry consists of an associate and the file containing their receipts.
 */

/*TODO:
 * When a new entry is created, a parser should be called to extract 
 * the associate's name and the receipts from the file. Then create a new
 * associate object and add it to the entry.
 */
public class Entry {
    private Associate associate;
    private File file;

    public Entry(File file, Associate associate) {
        this.file = file;
        this.associate = associate;
    }

    public Associate getAssociate() {
        return associate;
    }

    public File getFile() {
        return file;
    }

    public void setAssociate(Associate associate) {
        this.associate = associate;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
