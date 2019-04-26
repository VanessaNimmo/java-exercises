package com.ness.conways.grid;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Grid2DTest {

    private Cell makeCell(int row, int column, LifeType lifeType) {
        return new Cell(new Location(row, column), lifeType);
    }
    @Test
    public void cellShouldBeAliveInAOneByOneGridOfALiveCell() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(makeCell(0, 0, LifeType.ALIVE));
        Grid2D oneLiveCell = new Grid2D(initialCellList, 1, 1);

        LifeType result = oneLiveCell.getCellList().get(0).getLifeType();

        assertEquals(result, LifeType.ALIVE);
    }

    @Test
    public void cellShouldBeDeadInAOneByOneGridOfADeadCell() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(makeCell(0, 0, LifeType.DEAD));
        Grid2D oneLiveCell = new Grid2D(initialCellList, 1, 1);

        LifeType result = oneLiveCell.getCellList().get(0).getLifeType();

        assertEquals(result, LifeType.DEAD);
    }

    @Test
    public void aliveNeighboursShouldReturn8ForAOneByOneGridOfALiveCell() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(makeCell(0, 0, LifeType.ALIVE));
        Grid2D oneLiveCell = new Grid2D(initialCellList, 1, 1);

        int result = oneLiveCell.getNeighboursOfType(new Location(0, 0), LifeType.ALIVE);

        assertEquals(8, result);
    }

    @Test
    public void aliveNeighboursShouldReturn0ForAOneByOneGridOfADeadCell() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(makeCell(0, 0, LifeType.DEAD));
        Grid2D oneLiveCell = new Grid2D(initialCellList, 1, 1);

        int result = oneLiveCell.getNeighboursOfType(new Location(0, 0), LifeType.ALIVE);

        assertEquals(0, result);
    }

    @Test
    public void aliveNeighboursShouldReturn0ForALiveCellSurroundedByDeadCells() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(makeCell(0, 0, LifeType.DEAD));
        initialCellList.add(makeCell(0, 1, LifeType.DEAD));
        initialCellList.add(makeCell(0, 2, LifeType.DEAD));
        initialCellList.add(makeCell(1, 0, LifeType.DEAD));
        initialCellList.add(makeCell(1, 1, LifeType.ALIVE));
        initialCellList.add(makeCell(1, 2, LifeType.DEAD));
        initialCellList.add(makeCell(2, 0, LifeType.DEAD));
        initialCellList.add(makeCell(2, 1, LifeType.DEAD));
        initialCellList.add(makeCell(2, 2, LifeType.DEAD));

        Grid2D anIsolatedCell = new Grid2D(initialCellList, 3, 3);

        int result = anIsolatedCell.getNeighboursOfType(new Location(1, 1), LifeType.ALIVE);

        assertEquals(0, result);
    }

    @Test
    public void aliveNeighboursShouldReturn1ForALiveCellWithOneLiveNeighbour() {
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

        Grid2D anIsolatedCell = new Grid2D(initialCellList, 3, 3);

        int result = anIsolatedCell.getNeighboursOfType(new Location(1, 1), LifeType.ALIVE);

        assertEquals(1, result);
    }

    @Test
    public void liveCellsOnEdgesShouldBeCountedAsWrappedForTheOppositeSideOfTheGrid() {
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

        Grid2D anIsolatedCell = new Grid2D(initialCellList, 3, 3);

        int result = anIsolatedCell.getNeighboursOfType(new Location(1, 0), LifeType.ALIVE);

        assertEquals(1, result);
    }

    @Test
    public void liveCellsOnCornersShouldWrapToOppositeDiagonalsToBeCountedAsNeighbours() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(0, 1), LifeType.ALIVE));
        initialCellList.add(new Cell(new Location(1, 0), LifeType.DEAD));
        initialCellList.add(new Cell(new Location(1, 1), LifeType.DEAD));
        Grid2D twoByTwoGrid = new Grid2D(initialCellList, 2, 2);

        int result = twoByTwoGrid.getNeighboursOfType(new Location(0, 0), LifeType.ALIVE);

        assertEquals(2, result);
    }
}