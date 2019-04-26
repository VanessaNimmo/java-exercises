package com.ness.conways.grid;

import com.ness.conways.grid.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class GridCalculatorTest {

    @Test
    public void aLiveCellWithThreeLiveNeighboursShouldBeAliveInNextTick() {
        GridCalculator calculator = new GridCalculator();
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),false));
        initialCellList.add(new Cell(new Location(0, 1), true));
        initialCellList.add(new Cell(new Location(0, 2), true));
        initialCellList.add(new Cell(new Location(1, 0), false));
        initialCellList.add(new Cell(new Location(1, 1), true));
        initialCellList.add(new Cell(new Location(1, 2), true));
        initialCellList.add(new Cell(new Location(2, 0), false));
        initialCellList.add(new Cell(new Location(2, 1), false));
        initialCellList.add(new Cell(new Location(2, 2), false));
        IGrid initialState = new Grid2D(initialCellList, 3, 3);

        Grid2D nextTick = calculator.getNextTick(initialState);
        // Next line is way too long
        boolean result = nextTick.getCellList().stream().filter(cell -> cell.getLocation().getRow() == 1 && cell.getLocation().getColumn() == 1).collect(Collectors.toList()).get(0).getAlive();

        assertTrue(result);
    }

    @Test
    public void aLiveCellWithTwoLiveNeighboursShouldBeAliveInNextTick() {
        GridCalculator calculator = new GridCalculator();
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),false));
        initialCellList.add(new Cell(new Location(0, 1), true));
        initialCellList.add(new Cell(new Location(0, 2), true));
        initialCellList.add(new Cell(new Location(1, 0), false));
        initialCellList.add(new Cell(new Location(1, 1), true));
        initialCellList.add(new Cell(new Location(1, 2), false));
        initialCellList.add(new Cell(new Location(2, 0), false));
        initialCellList.add(new Cell(new Location(2, 1), false));
        initialCellList.add(new Cell(new Location(2, 2), false));
        IGrid initialState = new Grid2D(initialCellList, 3, 3);

        Grid2D nextTick = calculator.getNextTick(initialState);
        // Looking for cell at location 1,1
        boolean result = nextTick.getCellList().stream().filter(cell -> cell.getLocation().getRow() == 1 && cell.getLocation().getColumn() == 1).collect(Collectors.toList()).get(0).getAlive();

        assertTrue(result);
    }

    @Test
    public void aDeadCellWithThreeLiveNeighboursShouldBeAliveInNextTick() {
        GridCalculator calculator = new GridCalculator();
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),false));
        initialCellList.add(new Cell(new Location(0, 1), true));
        initialCellList.add(new Cell(new Location(0, 2), true));
        initialCellList.add(new Cell(new Location(1, 0), false));
        initialCellList.add(new Cell(new Location(1, 1), false));
        initialCellList.add(new Cell(new Location(1, 2), true));
        initialCellList.add(new Cell(new Location(2, 0), false));
        initialCellList.add(new Cell(new Location(2, 1), false));
        initialCellList.add(new Cell(new Location(2, 2), false));
        IGrid initialState = new Grid2D(initialCellList, 3, 3);

        Grid2D nextTick = calculator.getNextTick(initialState);
        // Looking for cell at location 1,1
        boolean result = nextTick.getCellList().stream().filter(cell -> cell.getLocation().getRow() == 1 && cell.getLocation().getColumn() == 1).collect(Collectors.toList()).get(0).getAlive();

        assertTrue(result);
    }

    @Test
    public void aLiveCellWithOneLiveNeighbourShouldBeDeadInNextTick() {
        GridCalculator calculator = new GridCalculator();
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),false));
        initialCellList.add(new Cell(new Location(0, 1), false));
        initialCellList.add(new Cell(new Location(0, 2), false));
        initialCellList.add(new Cell(new Location(1, 0), false));
        initialCellList.add(new Cell(new Location(1, 1), true));
        initialCellList.add(new Cell(new Location(1, 2), true));
        initialCellList.add(new Cell(new Location(2, 0), false));
        initialCellList.add(new Cell(new Location(2, 1), false));
        initialCellList.add(new Cell(new Location(2, 2), false));
        IGrid initialState = new Grid2D(initialCellList, 3, 3);

        Grid2D nextTick = calculator.getNextTick(initialState);
        // Looking for cell at location 1,1
        boolean result = nextTick.getCellList().stream().filter(cell -> cell.getLocation().getRow() == 1 && cell.getLocation().getColumn() == 1).collect(Collectors.toList()).get(0).getAlive();

        assertFalse(result);
    }

    @Test
    public void aLiveCellWithFourOrMoreLiveNeighboursShouldBeDeadInNextTick() {
        GridCalculator calculator = new GridCalculator();
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),true));
        initialCellList.add(new Cell(new Location(0, 1), true));
        initialCellList.add(new Cell(new Location(0, 2), true));
        initialCellList.add(new Cell(new Location(1, 0), false));
        initialCellList.add(new Cell(new Location(1, 1), true));
        initialCellList.add(new Cell(new Location(1, 2), true));
        initialCellList.add(new Cell(new Location(2, 0), false));
        initialCellList.add(new Cell(new Location(2, 1), false));
        initialCellList.add(new Cell(new Location(2, 2), false));
        IGrid initialState = new Grid2D(initialCellList, 3, 3);

        Grid2D nextTick = calculator.getNextTick(initialState);
        // Looking for cell at location 1,1
        boolean result = nextTick.getCellList().stream().filter(cell -> cell.getLocation().getRow() == 1 && cell.getLocation().getColumn() == 1).collect(Collectors.toList()).get(0).getAlive();

        assertFalse(result);
    }

    @Test
    public void aDeadCellWithTwoOrFewerLiveNeighboursShouldRemainDeadInNextTick() {
        GridCalculator calculator = new GridCalculator();
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),false));
        initialCellList.add(new Cell(new Location(0, 1), false));
        initialCellList.add(new Cell(new Location(0, 2), false));
        initialCellList.add(new Cell(new Location(1, 0), true));
        initialCellList.add(new Cell(new Location(1, 1), false));
        initialCellList.add(new Cell(new Location(1, 2), true));
        initialCellList.add(new Cell(new Location(2, 0), false));
        initialCellList.add(new Cell(new Location(2, 1), false));
        initialCellList.add(new Cell(new Location(2, 2), false));
        IGrid initialState = new Grid2D(initialCellList, 3, 3);

        Grid2D nextTick = calculator.getNextTick(initialState);
        // Looking for cell at location 1,1
        boolean result = nextTick.getCellList().stream().filter(cell -> cell.getLocation().getRow() == 1 && cell.getLocation().getColumn() == 1).collect(Collectors.toList()).get(0).getAlive();

        assertFalse(result);
    }

    @Test
    public void aDeadCellWithFourOrMoreLiveNeighboursShouldRemainDeadInNextTick() {
        GridCalculator calculator = new GridCalculator();
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),false));
        initialCellList.add(new Cell(new Location(0, 1), false));
        initialCellList.add(new Cell(new Location(0, 2), true));
        initialCellList.add(new Cell(new Location(1, 0), true));
        initialCellList.add(new Cell(new Location(1, 1), false));
        initialCellList.add(new Cell(new Location(1, 2), true));
        initialCellList.add(new Cell(new Location(2, 0), true));
        initialCellList.add(new Cell(new Location(2, 1), false));
        initialCellList.add(new Cell(new Location(2, 2), false));
        IGrid initialState = new Grid2D(initialCellList, 3, 3);

        Grid2D nextTick = calculator.getNextTick(initialState);
        // Looking for cell at location 1,1
        boolean result = nextTick.getCellList().stream().filter(cell -> cell.getLocation().getRow() == 1 && cell.getLocation().getColumn() == 1).collect(Collectors.toList()).get(0).getAlive();

        assertFalse(result);
    }

}