package com.ness;

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
        boolean[][] nextGrid = io.getInitialState();
        for (int i=0; i < this.numberOfTicks; i++) {
            io.display(nextGrid);
            nextGrid = cellCalculator.getNextTick(nextGrid);
            try {
                Thread.sleep(this.sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
