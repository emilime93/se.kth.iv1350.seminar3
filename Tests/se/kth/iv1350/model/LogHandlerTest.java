package se.kth.iv1350.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Emil on 2017-05-22.
 */
public class LogHandlerTest {

    LogHandler logHandler;
    @Before
    public void setUp() throws Exception {
        logHandler = new LogHandler();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void logException() throws Exception {
        logHandler.logException(new Exception("DIN MOR"));
    }

}