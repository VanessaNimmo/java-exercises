package com.ness;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class ConsoleRandomPlayerIOTest {


    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void revertStreams() {
        System.setOut(sysOut);
    }

    @Test
    public void printsMessageWhenPrintIsCalled() {
        String message = "Welcome to Tic Tac Toe!";
        ConsoleRandomPlayerIO testConsole = new ConsoleRandomPlayerIO();

        testConsole.print(message);

        assertThat(outContent.toString(), containsString("Welcome to Tic Tac Toe!"));
    }

    @Test
    public void returnsAnIntWithinRangeWhenAskedForNextMove() {
        ConsoleRandomPlayerIO testConsole = new ConsoleRandomPlayerIO();

        int result = testConsole.getNextMove(1, 9, "123\n456\n789");

        assertTrue(1<= result && result <= 9);
    }

}