package com.ness;

class IOStub implements com.ness.InputOutput {

    boolean displayWasCalled;

    public boolean[][] getInitialState() {
        return new boolean[][]{{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};
    }

    public void display(boolean[][] state){
        this.displayWasCalled = true;
    }

    @Override
    public void print(String message) {}

    ;

    public boolean getDisplayWasCalled() { return displayWasCalled; }
}