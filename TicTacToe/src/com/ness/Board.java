package com.ness;

import java.util.Arrays;

public class Board {

    public final int size;
    public Square[][] state;

    public Board(int size) {
        this.size = size;
        this.state = new Square[this.size][this.size];
        for(int i=0; i<this.size; i++) {
            for(int j=0; j<this.size; j++) this.state[i][j] = new Square();
        }
    }

    public boolean moveIsOnBoard(int column, int row) {
        return column < size && row < size;
    }

    public void move(char entry, int column, int row) {
        if(moveIsOnBoard(column, row) && this.state[column][row].isEmpty) {
            this.state[column][row].makeEntry(entry);
        }
    }

}
