package com.ness;

public class ConsoleIO implements InputOutput {
    @Override
    public boolean sendWelcome(String message) {
        return message.equals("Welcome to Conway's Game of Life");
    }

    @Override
    public int[] getBoardSize() {
        return new int[] {10,20};
    }

    @Override
    public boolean[][] getInitialLiveCells() {
        boolean [][] result = {{false, false, false, false}, {false, true, false, false}, {false, false, false, true}, {false, false, false, false}};
        return result;
    }
}
