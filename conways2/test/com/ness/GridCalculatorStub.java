package com.ness;

class GridCalculatorStub implements GridCalculator {

    public Grid2D getNextTick(Grid2D currentState){
        boolean[][] nextState = new boolean[][] {{false, false, false, false}, {true, true, true, true}, {false, false, false, false}, {true, true, true, true}};
        return new Grid2D(nextState);
    };
}