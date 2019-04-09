package com.ness;

import java.util.ArrayList;

class OutputMock implements Output {

    boolean displayCellGridWasCalled;
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