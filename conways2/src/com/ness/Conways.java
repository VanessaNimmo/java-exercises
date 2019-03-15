package com.ness;

import java.util.ArrayList;

public class Conways {

    public static void main(String[] args) {

        InputOutput io = new ConsoleIO();
        int numberOfTicks = 5;
        Calculator cellCalculator = new CalculatorStarting();
        int sleepTime = 500;
        ArrayList<Grid> history = new ArrayList<Grid>;
        // get initial state?
        Grid initialState = getInitialState();
        // pass initial state into world?
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

    private static Grid getInitialState() {

    }

    private boolean[][] getNewGrid(Scanner in) {
        io.print("Please enter the height and width of the world grid, separated by a space:");
        String input = in.nextLine();
        int[] gridSize = parseIntegerPair(input);
        while (gridSize[0] > 56 || gridSize[1] > 56) {
            System.out.print("Please choose a grid size smaller than 56");
            input = in.nextLine();
            gridSize = parseIntegerPair(input);
        }
        return new boolean[gridSize[0]][gridSize[1]];
    }

    private boolean[][] addLiveStartingCells(boolean[][] startingGrid, Scanner in) {
        boolean finished = false;
        while (!finished) {
            startingGrid = addLiveCell(startingGrid, in);
            System.out.print("Add another cell? y/n");
            if(in.nextLine().equals("y")) {
                finished = true;
            }
        }
        return startingGrid;
    }

    private boolean[][] addLiveCell(boolean[][] startingGrid, Scanner in) {
        System.out.print("Enter the location of the live starting cell, counting across then down. Separate the numbers with a space: ");
        String input = in.nextLine();
        int[] cellLocation = parseIntegerPair(input);
        if (cellLocation[1] > startingGrid.length || cellLocation[0] > startingGrid[0].length) {
            System.out.print("Invalid placement. Please choose inside the grid.");
        } else {
            startingGrid[cellLocation[1]-1][cellLocation[0]-1] = true;
        }
        return startingGrid;
    }

    private int[] parseIntegerPair(String expression) {
        String[] splitInput = expression.split(" ");
        int[] integerPair = new int[2];
        for (int i=0; i < 2; i++) {
            integerPair[i] = Integer.parseInt(splitInput[i]);
        }
        return integerPair;
    }

    public boolean[][] getInitialState() {
        boolean[][] emptyGrid = getNewGrid(in);
        boolean[][] initialState = addLiveStartingCells(emptyGrid, in);
        return initialState;
    }


}
