package com.ness;

public class ConsoleRandomPlayerIO implements IO {

    @Override
    public void print(String message) { System.out.format("%s%n", message); }

    @Override
    public int getNextMove(int rangeMin, int rangeMax, String board) {
        return (int) Math.floor(Math.random()*rangeMax + 1);
    }
}
