package com.ness;

public class Board {

    public final int size;

    public Board(int size) {
        this.size = size;
    }

    public boolean moveIsValid(int entry, int xCoord, int yCoord) {
        if (xCoord >= size || yCoord >= size) return false;
        return true;
    }
}
