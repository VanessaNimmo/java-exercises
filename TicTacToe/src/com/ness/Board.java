package com.ness;

import java.util.Arrays;

class Board {

    final int size;
    Square[][] state;
    boolean isFull = false;

    Board(int size) {
        this.size = size;
        this.state = new Square[this.size][this.size];
        for(int i=0; i<this.size; i++) {
            for(int j=0; j<this.size; j++) this.state[i][j] = new Square();
        }
    }

    boolean moveIsOnBoard(int column, int row) {
        return column < size && row < size;
    }

    void move(char entry, int column, int row) {
        if(moveIsOnBoard(column, row) && this.state[column][row].isEmpty) {
            this.state[column][row].makeEntry(entry);
        }
        this.checkIfFull();
    }

    private void checkIfFull() {
        this.isFull = true;
        for(int i=0; i<this.size; i++) {
            for(int j=0; j<this.size; j++) if(this.state[i][j].isEmpty) this.isFull = false;
        }
    }
}
