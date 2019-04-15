package com.ness.conways;

import com.ness.conways.grid.IGrid;
import com.ness.conways.grid.IGridCalculator;
import com.ness.conways.grid.Grid2D;

class GridCalculatorStub implements IGridCalculator {

    boolean calculatorWasCalled = false;

    public Grid2D getNextTick(IGrid currentState){
        calculatorWasCalled = true;
        return (Grid2D) currentState;
    }
}