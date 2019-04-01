package com.ness;

import java.util.ArrayList;
import java.util.Arrays;

class Grid2D implements Grid {

    private final boolean[][] liveCells;

    Grid2D(boolean[][] state) { this.liveCells = state; }

    boolean[][] getCells() { return this.liveCells; }

    @Override
    public boolean cellIsAlive(int row, int column) {
        return this.liveCells[row-1][column-1];
    }

    @Override
    public int aliveNeighbours(int row, int column) {
        return getAliveNeighbours(row-1, column-1);
    }

    private int getAliveNeighbours(int row, int column) {
        int aliveNeighbours = 0;
        int rowAbove = getPrevious(row, this.liveCells.length);
        int rowBelow = getNext(row, this.liveCells.length);
        int columnBefore = getPrevious(column, this.liveCells[0].length);
        int columnAfter = getNext(column, this.liveCells[0].length);
        ArrayList<Boolean> cells = getCellsList(this.liveCells, rowAbove, row, rowBelow, columnBefore, column, columnAfter);
        aliveNeighbours = (int) cells.stream().filter(cell -> cell).count();
        return aliveNeighbours;
    }

    private ArrayList<Boolean> getCellsList(boolean[][] initialState, int rowAbove, int row, int rowBelow, int columnBefore, int column, int columnAfter) {
        return new ArrayList<>(
                Arrays.asList(initialState[rowAbove][columnBefore], initialState[rowAbove][column], initialState[rowAbove][columnAfter], initialState[row][columnBefore], initialState[row][columnAfter], initialState[rowBelow][columnBefore], initialState[rowBelow][column], initialState[rowBelow][columnAfter]));
    }

    private int getNext(int rowOrColumn, int totalNumber) {
        return rowOrColumn + 1 == totalNumber ? 0 : rowOrColumn + 1;
    }

    private int getPrevious(int rowOrColumn, int totalNumber) {
        return rowOrColumn - 1 < 0 ? totalNumber - 1 : rowOrColumn - 1;
    }
}