package com.ness;

import java.util.ArrayList;

class Conways {

    private final int numberOfTicks, sleepTimeInMs;
    private ArrayList<Grid> history;
    private final Output output;
    private final Calculator tickCalculator;

    Conways(Grid initialState, int numberOfTicks, int sleepTimeInMs, Output output, Calculator tickCalculator) {
        history = new ArrayList<>();
        history.add(initialState);
        this.numberOfTicks = numberOfTicks;
        this.sleepTimeInMs = sleepTimeInMs;
        this.output = output;
        this.tickCalculator = tickCalculator;
    }

    void run() {
        int count = 0;
        do {
            output.displayCellGrid(history.get(count).getCells());
            Grid nextTick = tickCalculator.getNextTick(history.get(count));
            history.add(nextTick);
            count++;
            try {
                Thread.sleep(sleepTimeInMs);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (count < numberOfTicks);

    }

    ArrayList<Grid> getHistory() {
        return this.history;
    }
}
