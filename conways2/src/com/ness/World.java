package com.ness;

import java.util.ArrayList;

class World {

    InputOutput io;
    private int numberOfTicks;
    private Calculator cellCalculator;
    private int sleepTime;

    World(InputOutput io, int numberOfTicks, Calculator cellCalculator, int sleepTime) {
        this.io = io;
        this.numberOfTicks = numberOfTicks;
        this.cellCalculator = cellCalculator;
        this.sleepTime = sleepTime;
    }

    void run() {
        boolean[][] initialState = io.getInitialState();
        ArrayList<boolean[][]> states = new ArrayList<>();
        states.add(initialState);
        for (int i=0; i < this.numberOfTicks; i++) {
            io.display(states.get(i));
            states.add(cellCalculator.getNextTick(states.get(i)));
            try {
                Thread.sleep(this.sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
