package com.ness;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class ConsoleHumanPlayerIOTest {

    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private InputStream sysIn;

    @Before
    public void setUpStreams() {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
        sysIn = System.in;
    }

    @After
    public void revertStreams() {
        System.setOut(sysOut);
        System.setIn(sysIn);
    }

    @Test
    public void printsMessageWhenPrintIsCalled() {
        String message = "Welcome to Tic Tac Toe!";
        ConsoleHumanPlayerIO testConsole = new ConsoleHumanPlayerIO();

        testConsole.print(message);

        assertThat(outContent.toString(), containsString("Welcome to Tic Tac Toe!"));
    }

    @Test
    public void returnsAnIntWhenAskedForNextMove() {
        ConsoleHumanPlayerIO testConsole = new ConsoleHumanPlayerIO();
        int boardSize = 3;
        int squareOfBoardSize = boardSize*boardSize;
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = testConsole.getNextMove(1, squareOfBoardSize, "1 2 3\n4 5 6\n7 8 9\n");

        assertEquals(2, result);
    }

    @Test
    public void printsAnErrorMessageWhenInputIsOutOfRange() {
        ConsoleHumanPlayerIO testConsole = new ConsoleHumanPlayerIO();
        int boardSize = 3;
        int squareOfBoardSize = boardSize*boardSize;
        String input = String.format("11%n3");
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        testConsole.getNextMove(1, squareOfBoardSize, "1 2 3\n4 5 6\n7 8 9\n");

        assertThat(outContent.toString(), containsString("Please choose a valid square:"));
    }

    @Test
    public void returns0IfUserEntersq() {
        ConsoleHumanPlayerIO testConsole = new ConsoleHumanPlayerIO();
        int boardSize = 3;
        int squareOfBoardSize = boardSize*boardSize;
        String input = String.format("q");
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = testConsole.getNextMove(1, squareOfBoardSize, "1 2 3\n4 5 6\n7 8 9\n");

        assertEquals(0, result);
    }

    @Test
    public void userCanEnterqAtAnyTimeAndItReturns0() {
        ConsoleHumanPlayerIO testConsole = new ConsoleHumanPlayerIO();
        int boardSize = 3;
        int squareOfBoardSize = boardSize*boardSize;
        String input = String.format("11%nq");
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = testConsole.getNextMove(1, squareOfBoardSize, "1 2 3\n4 5 6\n7 8 9\n");

        assertEquals(0, result);
    }

}