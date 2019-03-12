package com.ness;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;

public class ConsoleIOTest {

    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private InputStream sysIn;

    @Before
    public void setUpStreams() {
        sysOut = System.out;
        sysIn = System.in;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void revertStreams() {
        System.setOut(sysOut);
        System.setIn(sysIn);
    }

    @Test
    public void printShouldPrintReceivedInformationToConsole() {
        String message = "Welcome to Conways Game of Life";
        ConsoleIO consoleDisplay = new ConsoleIO();

        consoleDisplay.print(message);

        assertThat(outContent.toString(), containsString("Welcome to Conways Game of Life"));
    }

    @Test
    public void displayShouldPrintSunnyEmojiForLiveCell() {
        boolean[][] grid = {{true}};
        ConsoleIO consoleDisplay = new ConsoleIO();

        consoleDisplay.display(grid);

        assertThat(outContent.toString(), containsString("\uD83C\uDF06"));
    }

    @Test
    public void displayShouldPrintCloudyEmojiForDeadCell() {
        boolean[][] grid = {{false}};
        ConsoleIO consoleDisplay = new ConsoleIO();

        consoleDisplay.display(grid);

        assertThat(outContent.toString(), containsString("\uD83C\uDFD9"));
    }

    @Test
    public void displayShouldMoveToNewLineForEachRowOfGrid() {
        boolean[][] grid = {{false}, {true}, {false}};
        ConsoleIO consoleDisplay = new ConsoleIO();

        consoleDisplay.display(grid);

        assertThat(outContent.toString(), containsString("\uD83C\uDFD9\n\uD83C\uDF06\n\uD83C\uDFD9\n"));
    }

    @Test
    public void displayOutPutShouldStartWithANewLine() {
        boolean[][] grid = {{false}};
        ConsoleIO consoleDisplay = new ConsoleIO();

        consoleDisplay.display(grid);

        assertThat(outContent.toString(), startsWith("\n"));
    }

    @Test
    public void shouldGatherGridSizeInformationFromUser() {
        ConsoleIO consoleDisplay = new ConsoleIO();
        String input = "1 1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int[] result = consoleDisplay.getGridSize();

        assertArrayEquals(new int[]{1, 1}, result);
    }

}