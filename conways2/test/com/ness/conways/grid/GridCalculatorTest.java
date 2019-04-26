package com.ness.conways.grid;

import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GridCalculatorTest {

    @Test
    public void aLiveCellWithThreeLiveNeighboursShouldBeAliveInNextTick() {
        GridCalculator calculator = new GridCalculator();
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),LifeType.DEAD));
        initialCellList.add(new Cell(new Location(0, 1), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(0, 2), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(1, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(1, 1), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(1, 2), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(2, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(2, 1), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(2, 2), LifeType.DEAD));
        IGrid initialState = new Grid2D(initialCellList, 3, 3);

        Grid2D nextTick = calculator.getNextTick(initialState);

        LifeType result = nextTick.getCellList().stream().filter(cell -> cell.getLocation().getRow() == 1 && cell.getLocation().getColumn() == 1).collect(Collectors.toList()).get(0).getLifeType();

        assertEquals(result, LifeType.ALIVE);
    }

    @Test
    public void aLiveCellWithTwoLiveNeighboursShouldBeAliveInNextTick() {
        GridCalculator calculator = new GridCalculator();
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),LifeType.DEAD));
        initialCellList.add(new Cell(new Location(0, 1), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(0, 2), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(1, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(1, 1), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(1, 2), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(2, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(2, 1), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(2, 2), LifeType.DEAD));
        IGrid initialState = new Grid2D(initialCellList, 3, 3);

        Grid2D nextTick = calculator.getNextTick(initialState);
        LifeType result = nextTick.getCellList().stream().filter(cell -> cell.getLocation().getRow() == 1 && cell.getLocation().getColumn() == 1).collect(Collectors.toList()).get(0).getLifeType();

        assertEquals(result, LifeType.ALIVE);
    }

    @Test
    public void aDeadCellWithThreeLiveNeighboursShouldBeAliveInNextTick() {
        GridCalculator calculator = new GridCalculator();
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),LifeType.DEAD));
        initialCellList.add(new Cell(new Location(0, 1), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(0, 2), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(1, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(1, 1), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(1, 2), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(2, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(2, 1), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(2, 2), LifeType.DEAD));
        IGrid initialState = new Grid2D(initialCellList, 3, 3);

        Grid2D nextTick = calculator.getNextTick(initialState);
        LifeType result = nextTick.getCellList().stream().filter(cell -> cell.getLocation().getRow() == 1 && cell.getLocation().getColumn() == 1).collect(Collectors.toList()).get(0).getLifeType();

        assertEquals(result, LifeType.ALIVE);
    }

    @Test
    public void aLiveCellWithOneLiveNeighbourShouldBeDeadInNextTick() {
        GridCalculator calculator = new GridCalculator();
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(0, 1), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(0, 2), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(1, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(1, 1), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(1, 2), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(2, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(2, 1), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(2, 2), LifeType.DEAD));
        IGrid initialState = new Grid2D(initialCellList, 3, 3);

        Grid2D nextTick = calculator.getNextTick(initialState);
        LifeType result = nextTick.getCellList().stream().filter(cell -> cell.getLocation().getRow() == 1 && cell.getLocation().getColumn() == 1).collect(Collectors.toList()).get(0).getLifeType();

        assertEquals(result, LifeType.DEAD);
    }

    @Test
    public void aLiveCellWithFourOrMoreLiveNeighboursShouldBeDeadInNextTick() {
        GridCalculator calculator = new GridCalculator();
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(0, 1), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(0, 2), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(1, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(1, 1), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(1, 2), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(2, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(2, 1), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(2, 2), LifeType.DEAD));
        IGrid initialState = new Grid2D(initialCellList, 3, 3);

        Grid2D nextTick = calculator.getNextTick(initialState);
        LifeType result = nextTick.getCellList().stream().filter(cell -> cell.getLocation().getRow() == 1 && cell.getLocation().getColumn() == 1).collect(Collectors.toList()).get(0).getLifeType();

        assertEquals(result, LifeType.DEAD);
    }

    @Test
    public void aDeadCellWithTwoOrFewerLiveNeighboursShouldRemainDeadInNextTick() {
        GridCalculator calculator = new GridCalculator();
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(0, 1), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(0, 2), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(1, 0), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(1, 1), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(1, 2), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(2, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(2, 1), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(2, 2), LifeType.DEAD));
        IGrid initialState = new Grid2D(initialCellList, 3, 3);

        Grid2D nextTick = calculator.getNextTick(initialState);
        LifeType result = nextTick.getCellList().stream().filter(cell -> cell.getLocation().getRow() == 1 && cell.getLocation().getColumn() == 1).collect(Collectors.toList()).get(0).getLifeType();

        assertEquals(result, LifeType.DEAD);
    }

    @Test
    public void aDeadCellWithFourOrMoreLiveNeighboursShouldRemainDeadInNextTick() {
        GridCalculator calculator = new GridCalculator();
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(0, 1), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(0, 2), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(1, 0), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(1, 1), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(1, 2), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(2, 0), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(2, 1), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(2, 2), LifeType.DEAD));
        IGrid initialState = new Grid2D(initialCellList, 3, 3);

        Grid2D nextTick = calculator.getNextTick(initialState);
        LifeType result = nextTick.getCellList().stream().filter(cell -> cell.getLocation().getRow() == 1 && cell.getLocation().getColumn() == 1).collect(Collectors.toList()).get(0).getLifeType();

        assertEquals(result, LifeType.DEAD);
    }

}