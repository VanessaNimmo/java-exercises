package com.ness;

class Grid {

    private final boolean[][] liveCells;

    Grid(boolean[][] state) { this.liveCells = state; }

    boolean[][] getCells() { return this.liveCells; }

    public String toString() {
        StringBuilder stringRepresentation = new StringBuilder();
        stringRepresentation.append(String.format("%n"));
        String cell;
        int gridHeight = liveCells.length;
        int gridWidth = liveCells[0].length;
        for (int row = 0; row < gridHeight; row++ ) {
            for( int column = 0; column < gridWidth; column++) {
                cell = liveCells[row][column] ? "\uD83D\uDE01" : "\uD83D\uDC7B";
                stringRepresentation.append(cell);
            }
            stringRepresentation.append(String.format("%n"));
        }
        return String.valueOf(stringRepresentation);
    }
}
