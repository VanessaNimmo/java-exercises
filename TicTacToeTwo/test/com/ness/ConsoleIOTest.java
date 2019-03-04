package com.ness;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
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
    public void printsMessageWhenPrintIsCalled() {
        String message = "Welcome to Tic Tac Toe!";
        ConsoleIO testConsole = new ConsoleIO();

        testConsole.print(message);

        assertThat(outContent.toString(), containsString("Welcome to Tic Tac Toe!"));
    }

    @Test
    public void returnsAnIntWhenAskedForNextMove() {
        ConsoleIO testConsole = new ConsoleIO();
        int boardSize = 3;
        int squareOfBoardSize = boardSize*boardSize;

        int result = testConsole.getNextMove(1, squareOfBoardSize, "Player 1", "1 2 3\n4 5 6\n7 8 9\n");

        assertTrue(1<= result && result <= squareOfBoardSize);
    }

}