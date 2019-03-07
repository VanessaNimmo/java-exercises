package com.ness;

class Board {

    private final boolean[][] liveCells;

    Board(boolean[][] liveCells) {
        this.liveCells = liveCells;
    }

    boolean[][] getLiveCells() {
        return this.liveCells;
    }
}
