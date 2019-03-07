package com.ness;

class Calculator {

    boolean[][] run(boolean[][] currentLiveCells) {
        int numOfRows = currentLiveCells.length;
        int numOfColumns = currentLiveCells[0].length;
        boolean[][] newState = new boolean[numOfRows][numOfColumns];
        int liveNeighbours;
        for (int row = 0; row < numOfRows; row++) {
            for (int column = 0; column < numOfColumns; column++) {
                liveNeighbours = getLiveNeighbours(currentLiveCells, row, column);
                newState[row][column] = isCellAliveOnNext(liveNeighbours, currentLiveCells[row][column]);
            }
        }
        return newState;
    }

    private int getLiveNeighbours(boolean[][] currentLiveCells, int row, int column) {
        int liveNeighbours = 0;
        int previousRow = row-1;
        if (previousRow == -1) {
            previousRow = currentLiveCells.length;
        }
        int nextRow = row+1;
        if (nextRow == currentLiveCells.length) {
            nextRow = 0;
        }
        int previousColumn = column - 1;
        if (previousColumn == -1) {
            previousColumn = currentLiveCells[0].length;
        }
        int nextColumn = column + 1;
        if (nextColumn >)
    }

    private boolean isCellAliveOnNext(int liveNeighbours, boolean alive) {
        if(liveNeighbours==3) {
            return true;
        }
        return alive && liveNeighbours == 2;
    }




}
