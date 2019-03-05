package com.ness;

class TicTacToeBoard implements Board {

    private final int size;
    private Marker[] squares;

    TicTacToeBoard(int boardSize) {
        this.size = boardSize;
        this.squares = new Marker[boardSize*boardSize];
        for(int i=0; i<boardSize*boardSize; i++) {
            this.squares[i] = Marker.E;
        }
    }

    public int getSize() { return this.size; }

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
    public boolean markerHasWon() {
        boolean rowsWonX = this.checkRows(Marker.X);
        boolean columnsWonX = this.checkColumns(Marker.X);
        boolean diagonalsWonX = this.checkDiagonals(Marker.X);
        boolean rowsWonO = this.checkRows(Marker.O);
        boolean columnsWonO = this.checkColumns(Marker.O);
        boolean diagonalsWonO = this.checkDiagonals(Marker.O);
        if (rowsWonX || columnsWonX || diagonalsWonX) {
            return true;
        }
        return rowsWonO || columnsWonO || diagonalsWonO;
    }

    private boolean checkRows(Marker marker){
        int markersInRow;
        for(int row=0; row<this.size; row++) {
            markersInRow = 0;
            for(int column=0; column<this.size; column++) {
                if(this.squares[column + row*this.size].equals(marker)) markersInRow++;
            }
            if (markersInRow==this.size) return true;
        }
        return false;
    }

    private boolean checkColumns(Marker marker) {
        int markersInColumn;
        for (int column=0; column<this.size; column++) {
            markersInColumn = 0;
            for (int row=0; row<this.size; row++) {
                if (this.squares[column + row*this.size].equals(marker)) markersInColumn++;
            }
            if (markersInColumn==this.size) return true;
        }
        return false;
    }

    private boolean checkDiagonals(Marker marker) {
        int leftToRight = 0, rightToLeft = 0;
        for(int row=0; row < this.size; row++) {
            if (this.squares[row*this.size + row].equals(marker)) leftToRight++;
        }
        if (leftToRight == this.size) return true;
        for(int j=1; j <= this.size; j++) {
            if (this.squares[j*this.size - j].equals(marker)) rightToLeft++;
        }
        if (rightToLeft == this.size) return true;
        return false;
    }
}
