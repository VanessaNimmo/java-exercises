package com.ness;

import java.util.Arrays;

class IOStub implements com.ness.InputOutput {

    boolean displayWasCalled;
    int displayCount = 0;

    public boolean[][] getInitialState() {
        return new boolean[][]{{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};
    }

    public void display(boolean[][] state){
        this.displayWasCalled = true;
        System.out.print(Arrays.deepToString(state));
        displayCount++;
    }

    @Override
    public void print(String message) {}

}