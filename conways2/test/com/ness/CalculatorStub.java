package com.ness;

class CalculatorStub implements Calculator {

    public Grid getNextTick(Grid currentState){
        boolean[][] nextState = new boolean[][] {{false, false, false, false}, {true, true, true, true}, {false, false, false, false}, {true, true, true, true}};
        return new Grid(nextState);
    };



}