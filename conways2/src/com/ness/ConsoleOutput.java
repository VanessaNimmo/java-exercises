package com.ness;

public class ConsoleOutput implements Output {

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void displayCellGrid(boolean[][] cells) {
        StringBuilder stringRepresentation = new StringBuilder();
        stringRepresentation.append(String.format("%n"));
        String cell;
        int gridHeight = cells.length;
        int gridWidth = cells[0].length;
        for (int row = 0; row < gridHeight; row++ ) {
            for( int column = 0; column < gridWidth; column++) {
                cell = cells[row][column] ? "\uD83D\uDE01" : "\uD83D\uDC7B";
                stringRepresentation.append(cell);
            }
            stringRepresentation.append(String.format("%n"));
        }
        System.out.print(stringRepresentation);
    }
}