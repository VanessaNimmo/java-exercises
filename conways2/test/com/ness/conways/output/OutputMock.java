package com.ness.conways.output;

import com.ness.conways.grid.Cell;

import java.util.ArrayList;

public class OutputMock implements IOutput {

    public boolean displayCellGridWasCalled;
    public int printCount = 0;

    @Override
    public void print(String message) {
    }

    @Override
    public void displayCellGrid(ArrayList<Cell> cellList, int gridWidth) {
        this.displayCellGridWasCalled = true;
        printCount++;
    }
}