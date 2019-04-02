package com.ness;

public class Cell {

    private int row, column;
    private boolean alive;

    Cell(int row, int column, boolean alive){
        this.row = row;
        this.column = column;
        this.alive = alive;
    }

    int getRow() { return this.row; }
    int getColumn() { return this.column; }
    boolean getAlive() { return this.alive; }
}
