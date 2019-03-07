package com.ness;

public class ConsoleIO implements InputOutput {

    @Override
    public boolean sendWelcome(String message) {
        return true;
    }

    @Override
    public boolean[][] getInitialLiveCells() {
        return new boolean[][]{{false, false, false, false}, {false, true, false, false}, {false, false, false, true}, {false, false, false, false}};
    }
}
