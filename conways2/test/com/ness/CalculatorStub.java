package com.ness;

class CalculatorStub {

    boolean[][] getNextTick(boolean[][] currentState){
        return new boolean[][] {{false, false, false, false}, {true, true, true, true}, {false, false, false, false}, {true, true, true, true}};
    };

}