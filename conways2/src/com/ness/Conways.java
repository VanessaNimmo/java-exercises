package com.ness;

import java.util.ArrayList;

class Conways {

    private final int numberOfTicks, sleepTimeInMs;
    private ArrayList<Grid2D> history;
    private final Output output;
    private final GridCalculator calculator;
    private final int gridWidth;

    Conways(Grid2D initialState, int numberOfTicks, int sleepTimeInMs, Output output, GridCalculator calculator) {
        history = new ArrayList<>();
        history.add(initialState);
        this.numberOfTicks = numberOfTicks;
        this.sleepTimeInMs = sleepTimeInMs;
        this.output = output;
        this.calculator = calculator;
        this.gridWidth = initialState.getGridWidth();
    }

    void run() {
        int count = 0;
        do {
            output.displayCellGrid(history.get(count).getCellList(), gridWidth);
            Grid2D nextTick = calculator.getNextTick(history.get(count));
            history.add(nextTick);
            count++;
            try {
                Thread.sleep(sleepTimeInMs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (count < numberOfTicks);

    }

    ArrayList<Grid2D> getHistory() {
        return this.history;
    }
}
