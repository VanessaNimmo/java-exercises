package com.ness;

public class Conways {

    public static void main(String[] args) {

        InputOutput consoleIO = new ConsoleIO();
        int numberOfTicks = 5;
        CalculatorStarting cellCalculator = new CalculatorStarting();
        World conwaysWorld = new World(consoleIO, 5, cellCalculator);

    }
}
