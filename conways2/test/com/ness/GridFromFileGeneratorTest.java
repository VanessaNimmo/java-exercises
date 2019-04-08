package com.ness;

import org.junit.Test;

import java.io.File;
import java.util.Optional;

import static org.junit.Assert.*;

public class GridFromFileGeneratorTest {

    @Test
    public void aOneLineFileShouldProduceAOneByOneGridWithOneDeadCell() {
        Output output = new ConsoleOutput();
        File initialGridInfo = new File("test/com/ness/setup1.txt");
        GridFromFileGenerator reader = new GridFromFileGenerator(initialGridInfo,56);

        Optional<Grid2D> result = reader.getInitialState();

        Grid2D expected = new Grid2D(new boolean[1][1]);

        assertArrayEquals(expected.getCells(), result.get().getCells());
    }

    @Test
    public void aSecondLineInTheFileShouldBeAddedToTheGridAsALiveCellIfValid() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        GridFromFileGenerator parser = new GridFromFileGenerator(initialGridInfo, 56);

        Optional<Grid2D> result = parser.getInitialState();
        boolean[][] liveCells = new boolean[1][1];
        liveCells[0][0] = true;
        Grid2D expected = new Grid2D(liveCells);

        assertArrayEquals(expected.getCells(), result.get().getCells());
    }

    @Test
    public void aCorrectlyFormattedFileShouldBeParsed() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        GridFromFileGenerator parser = new GridFromFileGenerator(initialGridInfo, 56);

        Optional<Grid2D> grid = parser.getInitialState();

        assertTrue(grid.isPresent());
    }

    @Test
    public void anIncorrectlyFormattedFirstLineShouldReturnAnEmptyOptional() {
        File initialGridInfo = new File("test/com/ness/incorrectlyFormattedFirstLine.txt");
        Output output = new ConsoleOutput();
        GridFromFileGenerator parser = new GridFromFileGenerator(initialGridInfo, 56);

        Optional<Grid2D> grid = parser.getInitialState();

        assertTrue(grid.isEmpty());
    }

    @Test
    public void gridSizesGreaterThanTheSuppliedMaximumShouldReturnAnEmptyOptional() {
        File initialGridInfo = new File("test/com/ness/gridSizeLargerThanMaximum.txt");
        Output output = new ConsoleOutput();
        GridFromFileGenerator parser = new GridFromFileGenerator(initialGridInfo, 56);

        Optional<Grid2D> grid = parser.getInitialState();

        assertTrue(grid.isEmpty());
    }

    @Test
    public void shouldAcceptGridSizesSmallerThanMaxGridSize() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        GridFromFileGenerator parser = new GridFromFileGenerator(initialGridInfo, 56);

        Optional<Grid2D> grid = parser.getInitialState();

        assertTrue(grid.isPresent());
    }

    @Test
    public void gridSizeLessThanZeroShouldReturnEmptyOptional() {
        File initialGridInfo = new File("test/com/ness/gridSizeLessThanZero.txt");
        Output output = new ConsoleOutput();
        GridFromFileGenerator parser = new GridFromFileGenerator(initialGridInfo, 56);

        Optional<Grid2D> grid = parser.getInitialState();

        assertTrue(grid.isEmpty());
    }

    @Test
    public void shouldAcceptCellPlacementsInsideAGivenGrid() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        GridFromFileGenerator parser = new GridFromFileGenerator(initialGridInfo, 56);

        Optional<Grid2D> grid = parser.getInitialState();

        // TODO Need to check that the cellList contains a cell at 1,1 that is alive

    }

    @Test
    public void shouldIgnoreCellPlacementOutsideTheGivenGridAndContinueToPlaceLiveCells() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        GridFromFileGenerator parser = new GridFromFileGenerator(initialGridInfo, 56);
        boolean[][] emptyGrid = new boolean[10][10];
        int[] cellLocation = {11, 3};

        // TODO Create an appropriate test file that shows it will ignore numbers outside the given grid
    }

    @Test
    public void shouldIgnoreCellPlacementsBelow0() {
        File initialGridInfo = new File("test/com/ness/setup1livecell.txt");
        Output output = new ConsoleOutput();
        GridFromFileGenerator parser = new GridFromFileGenerator(initialGridInfo, 56);

        // TODO Create an appropriate test file that shows it will ignore numbers below zero

    }
}