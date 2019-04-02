package com.ness;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GridCalculator2D implements GridCalculator {

    @Override
    public Grid2D getNextTick(Grid2D initialState) {
        return evolve(initialState);
    }

    private Grid2D evolve(Grid2D initialState) {
        ArrayList<Cell> cellList = initialState.getCellList();
        List<Cell> collect = cellList.stream().map(cell -> isCellAlive(cell, initialState)).collect(Collectors.toList());
        return new Grid2D(collect, initialState.getGridHeight(), initialState.getGridWidth());
    }

    private Cell isCellAlive(Cell cell, Grid2D initialState) {
            if (initialState.getAliveNeighbours(cell.getRow(), cell.getColumn())==3) {
                return new Cell(cell.getRow(), cell.getColumn(), true);
            }
            if (initialState.getAliveNeighbours(cell.getRow(), cell.getColumn()) == 2 && cell.getAlive()) {
                return new Cell(cell.getRow(), cell.getColumn(), true);
            }
            return new Cell(cell.getRow(), cell.getColumn(), false);
        }
}
