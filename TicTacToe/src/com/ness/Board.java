package com.ness;

public class Board {

    public final int size;
    public char[][] state;

    public Board(int size) {
        this.size = size;
        this.state = new char[][] {{'.', '.', '.'}, {'.', '.', '.'}, {'.', '.', '.'}};
    }

    public boolean moveIsOnBoard(char entry, int column, int row) {
        if (column >= size || row >= size) return false;
        return true;
    }

    public void move(char entry, int column, int row) {
        if(moveIsOnBoard(entry, column, row) && squareIsEmpty(column, row)) {
            this.state[column][row] = entry;
        }
    }

    public boolean squareIsEmpty(int column, int row) {
        // Feels like this needs a square class
        return true;
    }
}
