package com.ness;

class TicTacToeBoard implements Board {

    private final int size;
    Marker[] squares;
    WinChecker checker;

    TicTacToeBoard(int boardSize, WinChecker checker) {
        this.size = boardSize;
        this.squares = new Marker[boardSize*boardSize];
        this.checker = checker;
        for(int i=0; i<boardSize*boardSize; i++) {
            this.squares[i] = Marker.E;
        }
    }

    public int getSize() { return this.size; }

    public Marker[] getSquares() {
        return squares;
    }

    @Override
    public boolean isFull() {
        boolean full = true;
        for(int i=0; i<this.size*this.size; i++) {
            if(this.squares[i] == Marker.E) {
                full = false;
            }
        }
        return full;
    }

    @Override
    public String toString() {
        StringBuilder boardRep = new StringBuilder();
        for(int square=0; square<this.squares.length; square++){
            if(this.squares[square]==Marker.E) {
                boardRep.append((square + 1));
            } else {
                boardRep.append(squares[square]);
            }
            if((square+1)%this.size==0) boardRep.append('\n');
        }
        return boardRep.toString();
    }

    @Override
    public boolean squareIsAvailable(int markerPlacement) {
        return (this.squares[markerPlacement-1]==Marker.E);
    }

    @Override
    public void placeMarker(Marker marker, int markerPlacement) {
        this.squares[markerPlacement-1] = marker;
    }

    @Override
    public boolean gameIsWon() {
        return this.checker.gameIsWon(squares, size);
    }
}
