package com.ness;

public interface InputOutput {

    boolean sendWelcome(String message);

    int[] getBoardSize();

    boolean[][] getInitialLiveCells();
}
