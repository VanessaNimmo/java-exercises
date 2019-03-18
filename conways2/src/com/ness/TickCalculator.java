package com.ness;

import java.util.ArrayList;
import java.util.Arrays;

class TickCalculator implements Calculator {

    public Grid getNextTick(Grid initialGrid) {
        boolean[][] initialState = initialGrid.getCells();
        int gridHeight = initialState.length;
        int gridWidth = initialState[0].length;
        int aliveNeighbours;
        boolean[][] newState = new boolean[gridHeight][gridWidth];
        for (int row = 0; row < gridHeight; row++) {
            for (int column = 0; column < gridWidth; column++) {
                aliveNeighbours = getAliveNeighbours(initialState, row, column);
                newState[row][column] = isCellAlive(aliveNeighbours, initialState[row][column]);
            }
        }
        return new Grid(newState);
    }

    private boolean isCellAlive(int aliveNeighbours, boolean alive) {
        if (aliveNeighbours==3) {
            return true;
        }
        return aliveNeighbours == 2 && alive;
    }

    private int getAliveNeighbours(boolean[][] initialState, int row, int column) {
        int aliveNeighbours = 0;
        int rowAbove = getPrevious(row, initialState.length);
        int rowBelow = getNext(row, initialState.length);
        int columnBefore = getPrevious(column, initialState[0].length);
        int columnAfter = getNext(column, initialState[0].length);
        ArrayList<Boolean> cells = getCellsList(initialState, rowAbove, row, rowBelow, columnBefore, column, columnAfter);
        aliveNeighbours = (int) cells.stream().filter(cell -> cell).count();
        return aliveNeighbours;
    }

    private ArrayList<Boolean> getCellsList(boolean[][] initialState, int rowAbove, int row, int rowBelow, int columnBefore, int column, int columnAfter) {
        return new ArrayList<Boolean>(
                Arrays.asList(initialState[rowAbove][columnBefore], initialState[rowAbove][column], initialState[rowAbove][columnAfter], initialState[row][columnBefore], initialState[row][columnAfter], initialState[rowBelow][columnBefore], initialState[rowBelow][column], initialState[rowBelow][columnAfter]));
    }

    private int getNext(int rowOrColumn, int totalNumber) {
        return rowOrColumn + 1 == totalNumber ? 0 : rowOrColumn + 1;
    }

    private int getPrevious(int rowOrColumn, int totalNumber) {
        return rowOrColumn - 1 < 0 ? totalNumber - 1 : rowOrColumn - 1;
    }
}
