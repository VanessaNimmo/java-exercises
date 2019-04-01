package com.ness;

import java.util.ArrayList;

class Conways {

    private final int numberOfTicks, sleepTimeInMs;
    private ArrayList<Grid2D> history;
    private final Output output;

    Conways(Grid2D initialState, int numberOfTicks, int sleepTimeInMs, Output output) {
        history = new ArrayList<>();
        history.add(initialState);
        this.numberOfTicks = numberOfTicks;
        this.sleepTimeInMs = sleepTimeInMs;
        this.output = output;
    }

    void run() {
        int count = 0;
        do {
            output.displayCellGrid(history.get(count).getCells());
            Grid2D nextTick = new Grid2D(history.get(count).getCells());
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
