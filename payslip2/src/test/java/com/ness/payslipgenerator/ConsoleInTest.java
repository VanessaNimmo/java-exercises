package com.ness.payslipgenerator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class ConsoleInTest {

    private InputStream sysIn;

    @Before
    public void setUp() throws Exception {
        sysIn = System.in;
    }

    @After
    public void tearDown() throws Exception {
        System.setIn(sysIn);
    }

    @Test
    public void acceptsStringAndReturnsIt() {
        ConsoleIn consoleIn = new ConsoleIn();
        String input = "John";

        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);

        assertEquals(input, consoleIn.getInput());
    }
}