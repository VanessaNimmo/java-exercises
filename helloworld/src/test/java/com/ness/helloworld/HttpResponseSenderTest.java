package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HttpResponseSenderTest {

    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() {
        System.setOut(sysOut);
    }

    @Test
    public void shouldSendResponseGivenToIt() throws IOException {
        HttpResponseSender sender = new HttpResponseSender();
        HttpExchange mockedExchange = mock(HttpExchange.class);
        when(mockedExchange.getResponseBody()).thenReturn(outContent);
        mockedExchange.sendResponseHeaders(200, 13);

        HttpResponse response = new HttpResponse("Test response", 200);

        sender.send(response, mockedExchange);

        assertThat(outContent.toString(), containsString("Test response"));
    }
}