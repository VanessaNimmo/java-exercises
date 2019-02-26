package com.ness;

import java.util.Arrays;

// class TicTacToeBoard implements Board
// a board is a grid that takes a mark - that might be it - maybe you can also ask if it is full
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

    private boolean moveIsOnBoard(int column, int row) {
        return column < size && row < size;
    }

    // move might need to be in the player class, and maybe the game needs to ask the board if it is full before accepting another move from a player?
    void move(char entry, int column, int row) {
        if(!moveIsOnBoard(column, row) ) {
            // throw an exception
        } else if (!this.state[column][row].isEmpty) {
            // throw a different exception
        } else {
            this.state[column][row].makeEntry(entry);
        }
        this.checkIfFull();
    }

    // call this from outside the board at the appropriate time to check if it is full
    public boolean checkIfFull() {
        this.isFull = true;
        for(int i=0; i<this.size; i++) {
            for(int j=0; j<this.size; j++) if(this.state[i][j].isEmpty) this.isFull = false;
        }
    }
}
