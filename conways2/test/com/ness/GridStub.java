package com.ness;

class GridStub {

    private final boolean[][] liveCells;

    GridStub(boolean[][] initialState) {
        this.liveCells = initialState;
    }

    boolean[][] getLiveCells() { return this.liveCells;}
}