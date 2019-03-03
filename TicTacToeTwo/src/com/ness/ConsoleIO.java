package com.ness;

public class ConsoleIO implements IO {

    @Override
    public void print(String message) {
        System.out.format("%s%n%n", message);
    }

    @Override
    public int getBoard() {
        return 0;
    }
}
