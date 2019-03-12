package com.ness;

public class Conways {

    public static void main(String[] args) {

        InputOutput consoleIO = new ConsoleIO();
        int numberOfTicks = 5;
        Calculator cellCalculator = new CalculatorStarting();
        int sleepTime = 500;
        World conwaysWorld = new World(consoleIO, 5, cellCalculator, sleepTime);
        conwaysWorld.run();
    }
}
