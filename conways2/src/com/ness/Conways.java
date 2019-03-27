package com.ness;

import java.util.ArrayList;

class Conways {

    private final int numberOfTicks, sleepTimeInMs;
    private ArrayList<Grid> history;
    private final Output output;

    Conways(Grid initialState, int numberOfTicks, int sleepTimeInMs, Output output) {
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
            Grid nextTick = new Grid(history.get(count));
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
