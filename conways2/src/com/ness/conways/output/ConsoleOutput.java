package com.ness.conways.output;

import com.ness.conways.grid.Cell;
import com.ness.conways.output.IOutput;

import java.util.ArrayList;

public class ConsoleOutput implements IOutput {

    private static final String NEW_LINE = String.format("%n");
    private static final String SMILING_FACE_EMOJI = "\uD83D\uDE01";
    private static final String GHOST_EMOJI = "\uD83D\uDC7B";

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    @Override
    public void displayCellGrid(ArrayList<Cell> cellList, int gridWidth) {
        StringBuilder stringRepresentation = new StringBuilder();
        stringRepresentation.append(NEW_LINE);
        String cellAsString;
        for (int i = 0; i < cellList.size(); i++) {
            cellAsString = cellList.get(i).getAlive() ? SMILING_FACE_EMOJI : GHOST_EMOJI;
            stringRepresentation.append(cellAsString);
            if (isEndOfRow(gridWidth, i)) {
                stringRepresentation.append(NEW_LINE);
            }
        }
        stringRepresentation.append(NEW_LINE);
        System.out.print(stringRepresentation);
    }

    private boolean isEndOfRow(int gridWidth, int i) {
        return (i+1) % gridWidth == 0;
    }
}