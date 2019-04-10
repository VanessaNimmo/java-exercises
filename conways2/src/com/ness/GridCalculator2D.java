package com.ness;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GridCalculator2D implements IGridCalculator {

    @Override
    public Grid2D getNextTick(IGrid initialState) {
        return evolve(initialState);
    }

    private Grid2D evolve(IGrid initialState) {
        ArrayList<Cell> cellList = initialState.getCellList();
        List<Cell> nextTickCellList = cellList.stream().map(cell -> isCellAlive(cell, initialState)).collect(Collectors.toList());
        return new Grid2D(nextTickCellList, initialState.getGridHeight(), initialState.getGridWidth());
    }

    private Cell isCellAlive(Cell cell, IGrid initialState) {
            if (initialState.getAliveNeighbours(cell.getRow(), cell.getColumn())==3) {
                return new Cell(cell.getRow(), cell.getColumn(), true);
            }
            if (initialState.getAliveNeighbours(cell.getRow(), cell.getColumn()) == 2 && cell.getAlive()) {
                return new Cell(cell.getRow(), cell.getColumn(), true);
            }
            return new Cell(cell.getRow(), cell.getColumn(), false);
        }
}
