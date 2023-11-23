package main.fileAppender;
import main.domain.Associate;
import main.domain.Receipt;

import java.io.*;

public abstract class FileAppender {

    protected File fileToAppend;
    protected Receipt receiptToAppend;

    public void appendReceipt(Receipt receipt, Associate associate) throws Exception {
        fileToAppend = associate.getPersonalFile();
        receiptToAppend = receipt;
        associate.addReceipt(receipt);

        openFile();
        writeReceipt();
        closeFile();
    };

    protected abstract void openFile() throws Exception;

    protected abstract void writeReceipt() throws Exception;

    protected abstract void closeFile() throws Exception;

}

