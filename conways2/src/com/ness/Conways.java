package com.ness;

import java.util.ArrayList;

class Conways {

    private final int numberOfTicks, sleepTimeInMs;
    private ArrayList<Grid> history;
    private Output output;

    Conways(Grid initialState, int numberOfTicks, int sleepTimeInMs, Output output) {
        history = new ArrayList<>();
        history.add(initialState);
        this.numberOfTicks = numberOfTicks;
        this.sleepTimeInMs = sleepTimeInMs;
        this.output = output;
    }

    void run() {
        int count = 0;

        while (count < numberOfTicks) {
            output.print(String.valueOf(history.get(0)));
            count++;
        }

    }
}
