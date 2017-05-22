package se.kth.iv1350.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Emil on 2017-05-22.
 */
public class LogHandler {

    private final static String FILE_NAME = "exception-log.txt";

    private PrintWriter printWriter;

    public LogHandler() throws IOException {
        printWriter = new PrintWriter(new FileWriter(FILE_NAME), true);
    }

    public void logException(Throwable exception) {
        StringBuilder sb = new StringBuilder();
        sb.append("--New exception thrown at: ");
        sb.append(new Date() + "\n");
        sb.append("-Details: ");
        sb.append(exception.getMessage());
        printWriter.println(sb);
    }
}
