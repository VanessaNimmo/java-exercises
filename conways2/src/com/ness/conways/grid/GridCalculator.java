package com.ness.conways.grid;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GridCalculator implements IGridCalculator {

    @Override
    public Grid2D getNextTick(IGrid initialState) {
        return evolve(initialState);
    }

    private Grid2D evolve(IGrid initialState) {
        ArrayList<Cell> cellList = initialState.getCellList();
        ArrayList<Cell> nextTickCellList = cellList.stream().map(cell -> isCellAlive(cell, initialState)).collect(Collectors.toCollection(ArrayList::new));
        return new Grid2D(nextTickCellList, initialState.getGridHeight(), initialState.getGridWidth());
    }

    private Cell isCellAlive(Cell cell, IGrid initialState) {
            if (initialState.getNeighboursOfType(cell.getLocation(), LifeType.ALIVE) == 3) {
                return new Cell(cell.getLocation(), LifeType.ALIVE);
            }
            if (initialState.getNeighboursOfType(cell.getLocation(), LifeType.ALIVE) == 2 && cell.getLifeType()==LifeType.ALIVE) {
                return new Cell(cell.getLocation(), LifeType.ALIVE);
            }
            return new Cell(cell.getLocation(), LifeType.DEAD);
        }
}
