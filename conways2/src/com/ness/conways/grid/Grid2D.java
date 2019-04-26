package com.ness.conways.grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid2D implements IGrid {

    private final ArrayList<Cell> cellList;
    private final int gridHeight, gridWidth;

    public Grid2D(ArrayList<Cell> cellList, int gridHeight, int gridWidth) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.cellList = cellList;
    }

    @Override
    public int getGridHeight() { return this.gridHeight; }

    @Override
    public int getGridWidth() { return this.gridWidth; }

    @Override
    public ArrayList<Cell> getCellList() { return this.cellList; }

    @Override
    public int getAliveNeighbours(Location location) {
        return calculateAliveNeighbours(location.getRow(), location.getColumn());
    }

    private int calculateAliveNeighbours(int row, int column) {
        int rowAbove = getPreviousRowOrColumn(row, this.gridHeight);
        int rowBelow = getNextRowOrColumn(row, this.gridHeight);
        int columnBefore = getPreviousRowOrColumn(column, this.gridWidth);
        int columnAfter = getNextRowOrColumn(column, this.gridWidth);
        boolean[][] gridRepresentation = constructGridRepresentation(this.cellList);
        List<Boolean> cells = getNeighbouringCellsList(gridRepresentation, rowAbove, row, rowBelow, columnBefore, column, columnAfter);
        return (int) cells.stream().filter(cell -> cell).count();
    }

    private boolean[][] constructGridRepresentation(ArrayList<Cell> cells) {
        boolean[][] cellRepresentation = new boolean[this.gridHeight][this.gridWidth];
        for (Cell cell : cells) {
            cellRepresentation[cell.getLocation().getRow()][cell.getLocation().getColumn()] = cell.getAlive();
        }
        return cellRepresentation;
    }

    private List<Boolean> getNeighbouringCellsList(boolean[][] initialState, int rowAbove, int row, int rowBelow, int columnBefore, int column, int columnAfter) {
        return Arrays.asList(
                initialState[rowAbove][columnBefore],
                initialState[rowAbove][column],
                initialState[rowAbove][columnAfter],
                initialState[row][columnBefore],
                initialState[row][columnAfter],
                initialState[rowBelow][columnBefore],
                initialState[rowBelow][column],
                initialState[rowBelow][columnAfter]);
    }

    private int getNextRowOrColumn(int rowOrColumn, int lengthOfRowOrColumn) {
        return rowOrColumn + 1 == lengthOfRowOrColumn ? 0 : rowOrColumn + 1;
    }

    private int getPreviousRowOrColumn(int rowOrColumn, int lengthOfRowOrColumn) {
        return rowOrColumn - 1 < 0 ? lengthOfRowOrColumn - 1 : rowOrColumn - 1;
    }
}