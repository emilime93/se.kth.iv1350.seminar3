package se.kth.iv1350.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * This is a log class, responsible for logging developer errors.
 */
public class LogHandler {

    private final static String FILE_NAME = "exception-logException.txt";

    private PrintWriter printWriter;

    /**
     * Creates a new instance of LogHandler and sets up which file it will write to.
     * @throws IOException If there's a problem with writing to the file, this will be thrown.
     */
    public LogHandler() throws IOException {
        printWriter = new PrintWriter(new FileWriter(FILE_NAME), true);
    }

    /**
     * This method logs the exceptions to a the log file set up in the constructor.
     * @param exception The exception to be logged.
     */
    public void logException(Throwable exception) {
        StringBuilder sb = new StringBuilder();
        sb.append("--New exception thrown at: ");
        sb.append(new Date()).append("\n");
        sb.append("-Details: ");
        sb.append(exception.getMessage());
        printWriter.println(sb);
        exception.printStackTrace(printWriter);
    }
}
