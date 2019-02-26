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
        for(int i=0; i<this.squares.length; i++){
            if(this.squares[i] == null) {
                boardRep.append(String.valueOf(i+1));
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
        return (this.squares[markerPlacement]==null);
    }

    @Override
    public void placeMarker(char marker, int markerPlacement) {
        this.squares[markerPlacement-1] = String.valueOf(marker);
    }
}
