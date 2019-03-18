package com.ness;

class IOStub implements Output {

    boolean displayWasCalled;
    int displayCount = 0;

    public boolean[][] getInitialState() {
        return new boolean[][]{{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};
    }

    public void display(boolean[][] state){
        this.displayWasCalled = true;
        displayCount++;
    }

    @Override
    public void print(String message) {}

}