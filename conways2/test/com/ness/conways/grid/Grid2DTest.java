package com.ness.conways;

import com.ness.conways.grid.Location;
import com.ness.conways.grid.Cell;
import com.ness.conways.grid.Grid2D;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Grid2DTest {

    // TODO: Add tests for the constructor as it contains logic (or be able to discuss why that logic is covered by the existing tests, or remove that logic)
    @Test
    public void cellShouldBeAliveInAOneByOneGridOfALiveCell() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),true));
        Grid2D oneLiveCell = new Grid2D(initialCellList, 1, 1);

        boolean result = oneLiveCell.getCellList().get(0).getAlive();

        assertTrue(result);
    }

    @Test
    public void cellShouldBeDeadInAOneByOneGridOfADeadCell() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),false));
        Grid2D oneLiveCell = new Grid2D(initialCellList, 1, 1);

        boolean result = oneLiveCell.getCellList().get(0).getAlive();

        assertFalse(result);
    }

    @Test
    public void aliveNeighboursShouldReturn8ForAOneByOneGridOfALiveCell() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),true));
        Grid2D oneLiveCell = new Grid2D(initialCellList, 1, 1);

        int result = oneLiveCell.getAliveNeighbours(new Location(0, 0));

        assertEquals(8, result);
    }

    @Test
    public void aliveNeighboursShouldReturn0ForAOneByOneGridOfADeadCell() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),false));
        Grid2D oneLiveCell = new Grid2D(initialCellList, 1, 1);

        int result = oneLiveCell.getAliveNeighbours(new Location(0, 0));

        assertEquals(0, result);
    }

    @Test
    public void aliveNeighboursShouldReturn0ForALiveCellSurroundedByDeadCells() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0),false));
        initialCellList.add(new Cell(new Location(0, 1), false));
        initialCellList.add(new Cell(new Location(0, 2), false));
        initialCellList.add(new Cell(new Location(1, 0), false));
        initialCellList.add(new Cell(new Location(1, 1), true));
        initialCellList.add(new Cell(new Location(1, 2), false));
        initialCellList.add(new Cell(new Location(2, 0), false));
        initialCellList.add(new Cell(new Location(2, 1), false));
        initialCellList.add(new Cell(new Location(2, 2), false));

        Grid2D anIsolatedCell = new Grid2D(initialCellList, 3, 3);

        int result = anIsolatedCell.getAliveNeighbours(new Location(1, 1));

        assertEquals(0, result);
    }

    @Test
    public void aliveNeighboursShouldReturn1ForALiveCellWithOneLiveNeighbour() {
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

        Grid2D anIsolatedCell = new Grid2D(initialCellList, 3, 3);

        int result = anIsolatedCell.getAliveNeighbours(new Location(1, 1));

        assertEquals(1, result);
    }

    @Test
    public void liveCellsOnEdgesShouldBeCountedAsWrappedForTheOppositeSideOfTheGrid() {
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

        Grid2D anIsolatedCell = new Grid2D(initialCellList, 3, 3);

        int result = anIsolatedCell.getAliveNeighbours(new Location(1, 0));

        assertEquals(1, result);
    }

    @Test
    public void liveCellsOnCornersShouldWrapToOppositeDiagonalsToBeCountedAsNeighbours() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0), true));
        initialCellList.add(new Cell(new Location(0, 1), true));
        initialCellList.add(new Cell(new Location(1, 0), false));
        initialCellList.add(new Cell(new Location(1, 1), false));
        Grid2D twoByTwoGrid = new Grid2D(initialCellList, 2, 2);

        int result = twoByTwoGrid.getAliveNeighbours(new Location(0, 0));

        assertEquals(2, result);
    }
}