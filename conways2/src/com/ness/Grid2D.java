package com.ness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Grid2D implements IGrid {

    private final boolean[][] cells;
    private final ArrayList<Cell> cellList;
    private int gridHeight, gridWidth;

    Grid2D(List<Cell> cells, int gridHeight, int gridWidth) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.cells = extractGrid(cells);
        this.cellList = makeCellList();
    }

    private boolean[][] extractGrid(List<Cell> cells) {
        boolean[][] cellRepresentation = new boolean[this.gridHeight][this.gridWidth];
        for (Cell cell : cells) {
            cellRepresentation[cell.getRow()][cell.getColumn()] = cell.getAlive();
        }
        return cellRepresentation;
    }

    private ArrayList<Cell> makeCellList() {
        int gridHeight = this.cells.length;
        int gridWidth = this.cells[0].length;
        ArrayList<Cell> cellsList = new ArrayList<>();
        for (int row = 0; row < gridHeight; row++) {
            for (int column = 0; column < gridWidth; column++) {
                cellsList.add(new Cell(row, column, this.cells[row][column]));
            }
        }
        return cellsList;
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
        int rowAbove = getPrevious(row, this.cells.length);
        int rowBelow = getNext(row, this.cells.length);
        int columnBefore = getPrevious(column, this.cells[0].length);
        int columnAfter = getNext(column, this.cells[0].length);
        List<Boolean> cells = getCellsList(this.cells, rowAbove, row, rowBelow, columnBefore, column, columnAfter);
        return (int) cells.stream().filter(cell -> cell).count();
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