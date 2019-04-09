package com.ness;

import java.util.ArrayList;

public class ConsoleOutput implements Output {

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    // TODO Make this deal with the flattened representation rather than the internal representation. Currently not working for a 2 by 2 grid
    @Override
    public void displayCellGrid(ArrayList<Cell> cellList, int gridWidth) {
        StringBuilder stringRepresentation = new StringBuilder();
        stringRepresentation.append(String.format("%n"));
        String cellAsString;
        for (int i=0; i<cellList.size(); i++) {
            cellAsString = cellList.get(i).getAlive() ? "\uD83D\uDE01" : "\uD83D\uDC7B";
            stringRepresentation.append(cellAsString);
            if (isEndOfRow(gridWidth, i)) {
                stringRepresentation.append(String.format("%n"));
            }
        }
        stringRepresentation.append(String.format("%n"));
        System.out.print(stringRepresentation);
    }

    private boolean isEndOfRow(int gridWidth, int i) {
        return (i+1) % gridWidth == 0;
    }
}