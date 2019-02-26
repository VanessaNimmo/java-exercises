package com.ness;

import java.util.Arrays;

class TicTacToeBoard implements Board {

    private final int size;
    private String[] squares;

    TicTacToeBoard(int boardSize) {
        this.size = boardSize;
        this.squares = new String[boardSize*boardSize];
        for(int i=0; i<boardSize*boardSize; i++) {
            this.squares[i] = "*";
        }
    }

    public int getSize() { return this.size; }

    @Override
    public boolean isFull() {
        boolean full = true;
        for(int i=0; i<this.size*this.size; i++) {
            if(this.squares[i].equals("*")) {
                full = false;
            }
        }
        return full;
    }

    @Override
    public String toString() {
        StringBuilder boardRep = new StringBuilder();
        for(int i=0; i<this.squares.length; i++){
            if(this.squares[i].equals("*")) {
                boardRep.append((i + 1));
            } else {
                boardRep.append(this.squares[i]);
            }
            if((i+1)%this.size==0) {
                boardRep.append('\n');
            }
        }
        return boardRep.toString();
    }

    @Override
    public boolean squareIsAvailable(int markerPlacement) {
        return (this.squares[markerPlacement-1].equals("*"));
    }

    @Override
    public void placeMarker(String marker, int markerPlacement) {
        this.squares[markerPlacement-1] = marker;
    }

    @Override
    public String markerHasWon() {
        boolean rowsWonX = this.checkRows("X");
        boolean columnsWonX = this.checkColumns("X");
        boolean diagonalsWonX = this.checkDiagonals("X");
        boolean rowsWonO = this.checkRows("O");
        boolean columnsWonO = this.checkColumns("O");
        boolean diagonalsWonO = this.checkDiagonals("O");
        if (rowsWonX || columnsWonX || diagonalsWonX) {
            return "X";
        }
        if (rowsWonO || columnsWonO || diagonalsWonO) {
            return "O";
        }
        return "N";
    }

    private boolean checkRows(String marker){
        if(this.squares[0].equals(marker) && this.squares[1].equals(marker) && this.squares[2].equals(marker)) {
            return true;
        }
        if(this.squares[3].equals(marker) && this.squares[4].equals(marker) && this.squares[5].equals(marker)) {
            return true;
        }
        if(this.squares[6].equals(marker) && this.squares[7].equals(marker) && this.squares[8].equals(marker)) {
            return true;
        }
        return false;
    }

    private boolean checkColumns(String marker) {
        if(this.squares[0].equals(marker) && this.squares[3].equals(marker) && this.squares[6].equals(marker)) {
            return true;
        }
        if(this.squares[1].equals(marker) && this.squares[4].equals(marker) && this.squares[7].equals(marker)) {
            return true;
        }
        if(this.squares[2].equals(marker) && this.squares[5].equals(marker) && this.squares[8].equals(marker)) {
            return true;
        }
        return false;
    }

    private boolean checkDiagonals(String marker) {
        if(this.squares[0].equals(marker) && this.squares[4].equals(marker) && this.squares[8].equals(marker)) {
            return true;
        }
        if(this.squares[2].equals(marker) && this.squares[4].equals(marker) && this.squares[6].equals(marker)) {
            return true;
        }
        return false;
    }
}
