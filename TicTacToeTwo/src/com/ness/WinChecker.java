package com.ness;

class WinChecker {

    public boolean gameIsWon(Marker[] squares, int size) {
        boolean rowsWonX = this.checkRows(Marker.X, squares, size);
        boolean columnsWonX = this.checkColumns(Marker.X, squares, size);
        boolean diagonalsWonX = this.checkDiagonals(Marker.X, squares, size);
        boolean rowsWonO = this.checkRows(Marker.O, squares, size);
        boolean columnsWonO = this.checkColumns(Marker.O, squares, size);
        boolean diagonalsWonO = this.checkDiagonals(Marker.O, squares, size);
        if (rowsWonX || columnsWonX || diagonalsWonX) {
            return true;
        }
        return rowsWonO || columnsWonO || diagonalsWonO;
    }

    private boolean checkRows(Marker marker, Marker[] squares, int size){
        int markersInRow;
        for(int row=0; row<size; row++) {
            markersInRow = 0;
            for(int column=0; column<size; column++) {
                if(squares[column + row*size].equals(marker)) markersInRow++;
            }
            if (markersInRow==size) return true;
        }
        return false;
    }

    private boolean checkColumns(Marker marker, Marker[] squares, int size) {
        int markersInColumn;
        for (int column=0; column<size; column++) {
            markersInColumn = 0;
            for (int row=0; row<size; row++) {
                if (squares[column + row*size].equals(marker)) markersInColumn++;
            }
            if (markersInColumn==size) return true;
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
