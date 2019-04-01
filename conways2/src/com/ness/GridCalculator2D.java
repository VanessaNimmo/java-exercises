package com.ness;

public class GridCalculator2D implements GridCalculator {

    @Override
    public Grid2D getNextTick(Grid2D initialState) {
        return null;
    }

//    private boolean[][] evolve() {
//        boolean[][] initialState = this.getCells();
//        int gridHeight = initialState.length;
//        int gridWidth = initialState[0].length;
//        int aliveNeighbours;
//        boolean[][] newState = new boolean[gridHeight][gridWidth];
//        for (int row = 0; row < gridHeight; row++) {
//            for (int column = 0; column < gridWidth; column++) {
//                aliveNeighbours = getAliveNeighbours(initialState, row, column);
//                newState[row][column] = isCellAlive(aliveNeighbours, initialState[row][column]);
//            }
//        }
//        return newState;
//    }

//        private boolean isCellAlive(int aliveNeighbours, boolean alive) {
//            if (aliveNeighbours==3) {
//                return true;
//            }
//            return aliveNeighbours == 2 && alive;
//        }
}
