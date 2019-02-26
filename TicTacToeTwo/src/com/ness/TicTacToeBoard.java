package com.ness;

class TicTacToeBoard implements Board {

    private final int size;
    private String[] squares;

    TicTacToeBoard(int boardSize) {
        this.size = boardSize;
        this.squares = new String[boardSize*boardSize];
    }

    public int getSize() { return this.size; }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder boardRep = new StringBuilder();
        for(i=0; i<this.squares.length; i++){
            boardRep.append("*");
        }
        return boardRep.toString();
    }
}
