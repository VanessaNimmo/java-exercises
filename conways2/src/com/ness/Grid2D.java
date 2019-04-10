package com.ness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Grid2D implements IGrid {

    private final ArrayList<Cell> cellList;
    private final int gridHeight, gridWidth;

    Grid2D(ArrayList<Cell> cells, int gridHeight, int gridWidth) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.cellList = cells;
    }

    @Override
    public int getGridHeight() { return this.gridHeight; }

    @Override
    public int getGridWidth() { return this.gridWidth; }

    @Override
    public ArrayList<Cell> getCellList() { return this.cellList; }

    @Override
    public int getAliveNeighbours(int row, int column) {
        return calculateAliveNeighbours(row, column);
    }

    private int calculateAliveNeighbours(int row, int column) {
        int rowAbove = getPrevious(row, this.gridHeight);
        int rowBelow = getNext(row, this.gridHeight);
        int columnBefore = getPrevious(column, this.gridWidth);
        int columnAfter = getNext(column, this.gridWidth);
        boolean[][] gridRepresentation = constructGridRepresentation();
        List<Boolean> cells = getCellsList(gridRepresentation, rowAbove, row, rowBelow, columnBefore, column, columnAfter);
        return (int) cells.stream().filter(cell -> cell).count();
    }

    private boolean[][] constructGridRepresentation() {
        boolean[][] cellRepresentation = new boolean[this.gridHeight][this.gridWidth];
        for (Cell cell : this.cellList) {
            cellRepresentation[cell.getRow()][cell.getColumn()] = cell.getAlive();
        }
        return cellRepresentation;
    }

    private List<Boolean> getCellsList(boolean[][] initialState, int rowAbove, int row, int rowBelow, int columnBefore, int column, int columnAfter) {
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

    private int getNext(int rowOrColumn, int totalNumber) {
        return rowOrColumn + 1 == totalNumber ? 0 : rowOrColumn + 1;
    }

    private int getPrevious(int rowOrColumn, int totalNumber) {
        return rowOrColumn - 1 < 0 ? totalNumber - 1 : rowOrColumn - 1;
    }
}