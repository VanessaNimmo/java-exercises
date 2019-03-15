package com.ness;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Conways {

    public static void main(String[] args) {

        InputOutput io = new ConsoleIO();
        int numberOfTicks = 5;
        Calculator cellCalculator = new CalculatorStarting();
        int sleepTime = 500;
        ArrayList<Grid> history = new ArrayList<Grid>();
        Grid initialState = getInitialState(io);
        io.display(initialState);
        history.add(initialState);
        int counter = 0;
        Grid startingState = initialState;
        while (counter < numberOfTicks) {
            Grid finalState = cellCalculator.getNextTick(startingState);
            history.add(finalState);
            io.display(finalState);
            startingState = finalState;
            counter++;
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Grid getInitialState(InputOutput io) {
        io.print("Please enter the height and width of the world grid, separated by a space:");
        int[] gridSize = getIntegerPair(io);
        while (!validGridSize(gridSize, io)) {
            io.print("Please enter a grid size smaller than 56");
            gridSize = getIntegerPair(io);
        }
        boolean[][] emptyGrid = new boolean[gridSize[0]][gridSize[1]];
        boolean[][] startingGrid = addLiveStartingCells(emptyGrid, io);
        return new Grid(startingGrid);
    }

    private static int[] getIntegerPair(InputOutput io) {
        Pattern numberPair = Pattern.compile("\\d*\\s\\d*");
        String expression = io.getInput();
        Matcher matcher = numberPair.matcher(expression);
        while (!matcher.matches()) {
            io.print(String.format("You entered %s. Please enter digits only, separated by a single space:", expression));
            expression = io.getInput();
            matcher = numberPair.matcher(expression);
        }
        return parseIntegerPair(expression);
    }

    private static boolean validGridSize(int[] gridSize, InputOutput io) {
        return (gridSize[0] < 56 && gridSize[1] < 56);
    }

    private static boolean[][] addLiveStartingCells(boolean[][] startingGrid, InputOutput io) {
        boolean finished = false;
        while (!finished) {
            startingGrid = addLiveCell(startingGrid, io);
            io.print("Add another cell? y/n");
            if(io.getInput().equals("n")) {
                finished = true;
            }
        }
        return startingGrid;
    }

    private static boolean[][] addLiveCell(boolean[][] startingGrid, InputOutput io) {
        io.print("Enter the location of the live starting cell, counting across then down. Separate the numbers with a space: ");
        int[] cellLocation = getIntegerPair(io);
        while(!validCellLocation(cellLocation, startingGrid)) {
            io.print("Invalid placement. Please choose inside the grid.");
            cellLocation = getIntegerPair(io);
        }
        startingGrid[cellLocation[1]-1][cellLocation[0]-1] = true;
        return startingGrid;
    }

    private static boolean validCellLocation(int[] cellLocation, boolean[][] startingGrid) {
        return (cellLocation[1] < startingGrid.length && cellLocation[0] < startingGrid[0].length);
    }

    private static int[] parseIntegerPair(String expression) {
        String[] splitInput = expression.split(" ");
        int[] integerPair = new int[2];
        for (int i=0; i < 2; i++) {
            integerPair[i] = Integer.parseInt(splitInput[i]);
        }
        return integerPair;
    }
}