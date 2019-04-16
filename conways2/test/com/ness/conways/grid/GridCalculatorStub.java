package com.ness.conways.grid;

public class GridCalculatorStub implements IGridCalculator {

    public boolean calculatorWasCalled = false;

    public Grid2D getNextTick(IGrid currentState){
        calculatorWasCalled = true;
        return (Grid2D) currentState;
    }
}