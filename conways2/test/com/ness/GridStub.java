package com.ness;

class GridStub {

    private final boolean[][] liveCells;

    GridStub(boolean[][] state) {
        this.liveCells = state;
    }

    boolean[][] getLiveCells() { return this.liveCells;}
}