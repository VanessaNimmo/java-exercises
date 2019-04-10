package com.ness;

public class Location {

    private final int row, column;

    Location(int row, int column) {
        this.row = row;
        this.column = column;
    }

    int getRow() { return this.row; }
    int getColumn() {return this.column; }
}
