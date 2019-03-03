package com.ness;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class ConsoleIOTest {

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
    public void printsWelcomeMessageWhenStartGameIsCalled() {
        String gameName = "Tic Tac Toe";
        ConsoleIO testConsole = new ConsoleIO();

        testConsole.startGame(gameName);

        assertThat(outContent.toString(), containsString("Welcome to Tic Tac Toe!"));
    }

}