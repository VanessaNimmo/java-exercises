package com.ness;

class OutputStub implements Output {

    boolean printWasCalled;
    int printCount = 0;

    @Override
    public void print(String message) {
        this.printWasCalled = true;
        printCount++;
    }

    @Override
    public void displayCellGrid(boolean[][] cells) {

    }

}