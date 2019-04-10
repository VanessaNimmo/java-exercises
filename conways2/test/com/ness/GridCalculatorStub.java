package com.ness;

class GridCalculatorStub implements IGridCalculator {

    boolean calculatorWasCalled = false;

    public Grid2D getNextTick(IGrid currentState){
        calculatorWasCalled = true;
        return (Grid2D) currentState;
    };
}