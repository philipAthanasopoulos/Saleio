package main.fileAppender;
import main.domain.Receipt;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public abstract class FileAppender {
	BufferedWriter writer;

    public abstract void appendReceipt(Receipt receipt, File receiptFile);
}

