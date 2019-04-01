package com.ness;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.*;

public class ConsoleOutputTest {

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
        ConsoleOutput consoleDisplay = new ConsoleOutput();

        consoleDisplay.print(message);

        assertThat(outContent.toString(), containsString("Welcome to Conways Game of Life"));
    }

    @Test
    public void displayShouldPrintSunnyEmojiForLiveCell() {
        boolean[][] grid = {{true}};
        Grid2D oneLiveCell = new Grid2D(grid);
        ConsoleOutput consoleDisplay = new ConsoleOutput();

        consoleDisplay.displayCellGrid(oneLiveCell.getCells());

        assertThat(outContent.toString(), containsString("\uD83D\uDE01"));
    }

    @Test
    public void displayShouldPrintCloudyEmojiForDeadCell() {
        boolean[][] grid = {{false}};
        Grid2D oneDeadCell = new Grid2D(grid);
        ConsoleOutput consoleDisplay = new ConsoleOutput();

        consoleDisplay.displayCellGrid(oneDeadCell.getCells());

        assertThat(outContent.toString(), containsString("\uD83D\uDC7B"));
    }

    @Test
    public void displayShouldMoveToNewLineForEachRowOfGrid() {
        boolean[][] grid = {{false}, {true}, {false}};
        Grid2D oneSmallWorld = new Grid2D(grid);
        ConsoleOutput consoleDisplay = new ConsoleOutput();

        consoleDisplay.displayCellGrid(oneSmallWorld.getCells());

        assertThat(outContent.toString(), containsString(String.format("\uD83D\uDC7B%n\uD83D\uDE01%n\uD83D\uDC7B%n")));
    }

    @Test
    public void displayOutPutShouldStartWithANewLine() {
        boolean[][] grid = {{false}};
        Grid2D oneDeadCell = new Grid2D(grid);
        ConsoleOutput consoleDisplay = new ConsoleOutput();

        consoleDisplay.displayCellGrid(oneDeadCell.getCells());

        assertThat(outContent.toString(), startsWith("\n"));
    }
}