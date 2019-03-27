package com.ness;

class Grid {

    private final boolean[][] liveCells;

    Grid(boolean[][] state) { this.liveCells = state; }

    boolean[][] getCells() { return this.liveCells; }
}
