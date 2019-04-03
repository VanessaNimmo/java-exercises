package com.ness;

import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class FileInputParserTest {

    @Test
    public void aOneLineFileShouldProduceAOneByOneGridWithOneDeadCell() {
        Output output = new ConsoleOutput();
        File initialGridInfo = new File("test/com/ness/setup1.txt");
        FileInputParser reader = new FileInputParser(initialGridInfo,56, output);

        Grid2D result = reader.getInitialState();

        Grid2D expected = new Grid2D(new boolean[1][1]);

        assertArrayEquals(expected.getCells(), result.getCells());
    }

    @Test
    public void aSecondLineInTheFileShouldBeAddedToTheGridAsALiveCellIfValid() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        FileInputParser parser = new FileInputParser(initialGridInfo, 56, output);

        Grid2D result = parser.getInitialState();
        boolean[][] liveCells = new boolean[1][1];
        liveCells[0][0] = true;
        Grid2D expected = new Grid2D(liveCells);

        assertArrayEquals(expected.getCells(), result.getCells());
    }

    @Test
    public void shouldReturnTrueWhenAStringInPutMatchesTheRequiredPattern() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        FileInputParser parser = new FileInputParser(initialGridInfo, 56, output);

        boolean result = parser.validInputString("5 5");

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenAStringInputDoesNotMatchTheRequiredPattern() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        FileInputParser parser = new FileInputParser(initialGridInfo, 56, output);

        boolean result = parser.validInputString("rtg 6");

        assertFalse(result);
    }

    @Test
    public void shouldRejectGridSizesGreaterThanSuppliedMaximumAndExitProgram() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        FileInputParser parser = new FileInputParser(initialGridInfo, 56, output);
        int[] gridSize = {57, 34};

        parser.validGridSize(gridSize);
    }

    @Test
    public void shouldAcceptGridSizesSmallerThanMaxGridSize() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        FileInputParser parser = new FileInputParser(initialGridInfo, 56, output);

        int[] gridSize = {25, 34};

        boolean result = parser.validGridSize(gridSize);

        assertTrue(result);
    }

    @Test
    public void shouldExitProgramIfSuppliedGridSizeIsLessThanZero() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        FileInputParser parser = new FileInputParser(initialGridInfo, 56, output);
        int[] gridSize = {-3, 34};

        parser.validGridSize(gridSize);
    }

    @Test
    public void shouldAcceptCellPlacementsInsideAGivenGrid() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        FileInputParser parser = new FileInputParser(initialGridInfo, 56, output);
        boolean[][] emptyGrid = new boolean[10][10];
        int[] cellLocation = {3, 3};

        boolean result = parser.validCellLocation(cellLocation, emptyGrid);

        assertTrue(result);
    }

    @Test
    public void shouldRejectCellPlacementOutsideAGivenGrid() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        FileInputParser parser = new FileInputParser(initialGridInfo, 56, output);
        boolean[][] emptyGrid = new boolean[10][10];
        int[] cellLocation = {11, 3};

        boolean result = parser.validCellLocation(cellLocation, emptyGrid);

        assertFalse(result);
    }

    @Test
    public void shouldRejectCellPlacementsBelow0() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        FileInputParser parser = new FileInputParser(initialGridInfo, 56, output);
        boolean[][] emptyGrid = new boolean[10][10];
        int[] cellLocation = {0, 3};

        boolean result = parser.validCellLocation(cellLocation, emptyGrid);

        assertFalse(result);
    }
}