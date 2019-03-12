package com.ness;

class World {

    InputOutput io;
    private int numberOfTicks;
    private Calculator cellCalculator;

    World(InputOutput io, int numberOfTicks, Calculator cellCalculator) {
        this.io = io;
        this.numberOfTicks = numberOfTicks;
        this.cellCalculator = cellCalculator;
    }

    void run() {
        boolean[][] nextGrid = io.getInitialState();
        for (int i=0; i < 5; i++) {
            nextGrid = cellCalculator.getNextTick(nextGrid);
            io.display(nextGrid);
        }
    }
}
