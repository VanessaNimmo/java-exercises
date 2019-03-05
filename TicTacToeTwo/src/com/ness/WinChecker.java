package com.ness;

class WinChecker {

    public boolean gameIsWon(Marker[] squares, int size) {
        boolean rowsWonX = this.checkLines(Marker.X, squares, size, true);
        boolean columnsWonX = this.checkLines(Marker.X, squares, size, false);
        boolean diagonalsWonX = this.checkDiagonals(Marker.X, squares, size);
        boolean rowsWonO = this.checkLines(Marker.O, squares, size, true);
        boolean columnsWonO = this.checkLines(Marker.O, squares, size, false);
        boolean diagonalsWonO = this.checkDiagonals(Marker.O, squares, size);
        if (rowsWonX || columnsWonX || diagonalsWonX) {
            return true;
        }
        return rowsWonO || columnsWonO || diagonalsWonO;
    }

    private boolean checkLines(Marker marker, Marker[] squares, int size, boolean rows) {
        int markersInLine;
        for(int column=0; column<size; column++) {
            markersInLine = 0;
            for(int row=0; row<size; row++) {
                if(rows) {
                    if(squares[row + column*size].equals(marker)) markersInLine++;
                } else {
                    if (squares[column + row*size].equals(marker)) markersInLine++;
                }
            }
            if (markersInLine==size) return true;
        }
        return false;
    }

    private boolean checkDiagonals(Marker marker, Marker[] squares, int size) {
        int leftToRight = 0, rightToLeft = 0;
        for(int row=0; row < size; row++) {
            if (squares[row*size + row].equals(marker)) leftToRight++;
        }
        if (leftToRight == size) return true;
        for(int j=1; j <= size; j++) {
            if (squares[j*size - j].equals(marker)) rightToLeft++;
        }
        if (rightToLeft == size) return true;
        return false;
    }
}