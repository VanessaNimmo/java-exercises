package com.ness.conways;

import com.ness.conways.grid.*;
import com.ness.conways.output.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

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
        String message = "Welcome to World Game of Life";
        ConsoleOutput consoleDisplay = new ConsoleOutput();

        consoleDisplay.print(message);

        assertThat(outContent.toString(), containsString("Welcome to World Game of Life"));
    }

    @Test
    public void displayShouldPrintSunnyEmojiForLiveCell() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0), true));
        Grid2D oneLiveCell = new Grid2D(initialCellList, 1, 1);
        ConsoleOutput consoleDisplay = new ConsoleOutput();
        int gridWidth = 1;

        consoleDisplay.displayCellGrid(oneLiveCell.getCellList(), gridWidth);

        assertThat(outContent.toString(), containsString("\uD83D\uDE01"));
    }

    @Test
    public void displayShouldPrintCloudyEmojiForDeadCell() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0), false));
        Grid2D oneDeadCell = new Grid2D(initialCellList, 1, 1);
        ConsoleOutput consoleDisplay = new ConsoleOutput();

        int gridWidth = 1;

        consoleDisplay.displayCellGrid(oneDeadCell.getCellList(), gridWidth);

        assertThat(outContent.toString(), containsString("\uD83D\uDC7B"));
    }

    @Test
    public void displayShouldMoveToNewLineForEachRowOfGrid() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0), false));
        initialCellList.add(new Cell(new Location(1, 0), true));
        initialCellList.add(new Cell(new Location(2, 0), false));
        Grid2D oneSmallWorld = new Grid2D(initialCellList, 3, 1);
        ConsoleOutput consoleDisplay = new ConsoleOutput();
        int gridWidth = 1;

        consoleDisplay.displayCellGrid(oneSmallWorld.getCellList(), gridWidth);

        assertThat(outContent.toString(), containsString(String.format("%n\uD83D\uDC7B%n\uD83D\uDE01%n\uD83D\uDC7B%n")));
    }

    @Test
    public void displayOutPutShouldStartWithANewLine() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0), false));
        Grid2D oneDeadCell = new Grid2D(initialCellList, 1, 1);
        ConsoleOutput consoleDisplay = new ConsoleOutput();
        int gridWidth = 1;

        consoleDisplay.displayCellGrid(oneDeadCell.getCellList(), gridWidth);

        assertThat(outContent.toString(), startsWith("\n"));
    }

    @Test
    public void displayShouldMoveToANewLineAtEndOfEachRow() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0), false));
        initialCellList.add(new Cell(new Location(0, 1), true));
        initialCellList.add(new Cell(new Location(1, 0), true));
        initialCellList.add(new Cell(new Location(1, 1), false));
        Grid2D twoByTwoGrid = new Grid2D(initialCellList, 2, 2);
        ConsoleOutput consoleDisplay = new ConsoleOutput();
        int gridWidth = 2;

        consoleDisplay.displayCellGrid(twoByTwoGrid.getCellList(), gridWidth);

        assertThat(outContent.toString(), containsString("\n\uD83D\uDC7B\uD83D\uDE01\n\uD83D\uDE01\uD83D\uDC7B\n"));
    }
}