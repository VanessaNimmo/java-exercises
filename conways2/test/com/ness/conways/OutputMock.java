package com.ness.conways;

import com.ness.conways.output.IOutput;
import com.ness.conways.grid.Cell;

import java.util.ArrayList;

class OutputMock implements IOutput {

    private boolean displayCellGridWasCalled;
    int printCount = 0;

    @Override
    public void print(String message) {
    }

    @Override
    public void displayCellGrid(ArrayList<Cell> cellList, int gridWidth) {
        this.displayCellGridWasCalled = true;
        printCount++;
    }
}