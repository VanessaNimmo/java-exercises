package com.ness;

class Calculator {
    boolean[][] getNextTick(boolean[][] initialState) {
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
        return newState;
    }

    private boolean isCellAlive(int aliveNeighbours, boolean alive) {
        if (aliveNeighbours==3) {
            return true;
        }
        if (aliveNeighbours==2 && alive) {
            return true;
        }
        return false;
    }

    private int getAliveNeighbours(boolean[][] initialState, int row, int column) {
        int aliveNeighbours = 0;
        int rowAbove = row - 1;
        if (rowAbove == -1) {
            rowAbove = initialState.length - 1;
        }
        int rowBelow = row + 1;
        if (rowBelow == initialState.length) {
            rowBelow = 0;
        }
        int columnBefore = column - 1;
        if (columnBefore == -1) {
            columnBefore = initialState[0].length - 1;
        }
        int columnAfter = column + 1;
        if (columnAfter == initialState[0].length) {
            columnAfter = 0;
        }
        if (initialState[rowAbove][columnBefore]) {
            aliveNeighbours++;
        }
        if (initialState[rowAbove][column]) {
            aliveNeighbours++;
        }
        if (initialState[rowAbove][columnAfter]) {
            aliveNeighbours++;
        }
        if (initialState[row][columnBefore]) {
            aliveNeighbours++;
        }
        if (initialState[row][columnAfter]) {
            aliveNeighbours++;
        }
        if (initialState[rowBelow][columnBefore]) {
            aliveNeighbours++;
        }
        if (initialState[rowBelow][column]) {
            aliveNeighbours++;
        }
        if (initialState[rowBelow][columnAfter]) {
            aliveNeighbours++;
        }
        return aliveNeighbours;
    }
}
