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

        while (count < numberOfTicks) {
            output.print(String.valueOf(history.get(0)));
            count++;
        }

    }
}
