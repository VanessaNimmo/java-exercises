package com.ness.conways;

import com.ness.conways.grid.IGrid;
import com.ness.conways.grid.IGridCalculator;
import com.ness.conways.output.IOutput;

import java.util.ResourceBundle;

class World {

    private final int numberOfTicks, sleepTimeInMs;
    private IGrid currentGrid;
    private final IOutput output;
    private final IGridCalculator calculator;
    private final int gridWidth;

    World(IGrid initialGrid, int numberOfTicks, int sleepTimeInMs, IOutput output, IGridCalculator calculator) {
        this.currentGrid = initialGrid;
        this.numberOfTicks = numberOfTicks;
        this.sleepTimeInMs = sleepTimeInMs;
        this.output = output;
        this.calculator = calculator;
        this.gridWidth = initialGrid.getGridWidth();
    }

    void run() {
        int count = 0;

        do {
            output.displayCellGrid(currentGrid.getCellList(), gridWidth);
            IGrid nextTick = calculator.getNextTick(currentGrid);
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
