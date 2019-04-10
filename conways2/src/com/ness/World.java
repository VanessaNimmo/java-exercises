package com.ness;

import java.util.ArrayList;

class Conways {

    private final int numberOfTicks, sleepTimeInMs;
    private Grid currentGrid;
    private final Output output;
    private final GridCalculator calculator;
    private final int gridWidth;

    Conways(Grid initialState, int numberOfTicks, int sleepTimeInMs, Output output, GridCalculator calculator) {
        this.currentGrid = initialState;
        this.numberOfTicks = numberOfTicks;
        this.sleepTimeInMs = sleepTimeInMs;
        this.output = output;
        this.calculator = calculator;
        this.gridWidth = initialState.getGridWidth();
    }

    void run() {
        int count = 0;
        do {
            output.displayCellGrid(currentGrid.getCellList(), gridWidth);
            Grid nextTick = calculator.getNextTick(currentGrid);
            currentGrid = nextTick;
            count++;
            try {
                Thread.sleep(sleepTimeInMs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (count < numberOfTicks);
    }
}
