package main.fileAppender;
import main.domain.Receipt;

import java.io.*;

public abstract class FileAppender {
	BufferedWriter writer;

    public abstract void appendReceipt(Receipt receipt, File receiptFile) throws Exception;
}

