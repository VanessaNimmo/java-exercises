package com.ness;

class OutputMock implements Output {

    boolean displayCellGridWasCalled;
    int printCount = 0;

    @Override
    public void print(String message) {

    }

    @Override
    public void displayCellGrid(boolean[][] cells) {
        this.displayCellGridWasCalled = true;
        printCount++;
    }

}