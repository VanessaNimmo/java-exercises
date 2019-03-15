package com.ness;

import java.util.ArrayList;

public class Conways {

    public static void main(String[] args) {

        InputOutput io = new ConsoleIO();
        int numberOfTicks = 5;
        Calculator cellCalculator = new TickCalculator();
        int sleepTime = 500;
        ArrayList<Grid> history = new ArrayList<>();

        io.print(String.valueOf(Message.WELCOME));
        Validator conwaysValidator = new Validator(56);
        Grid initialState = getInitialState(io, conwaysValidator);
        io.print(initialState.toString());
        history.add(initialState);

        int counter = 0;
        Grid startingState = initialState;
        while (counter < numberOfTicks) {
            Grid finalState = cellCalculator.getNextTick(startingState);
            history.add(finalState);
            io.print(finalState.toString());
            startingState = finalState;
            counter++;
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static Grid getInitialState(InputOutput io, Validator conwaysValidator) {
        io.print(String.valueOf(Message.GRID));
        int[] gridSize = getIntegerPair(io, conwaysValidator);
        while (!conwaysValidator.validGridSize(gridSize)) {
            io.print(String.valueOf(Message.GRID_SIZE_ERROR));
            gridSize = getIntegerPair(io, conwaysValidator);
        }
        boolean[][] emptyGrid = new boolean[gridSize[0]][gridSize[1]];
        boolean[][] startingGrid = addLiveStartingCells(emptyGrid, io, conwaysValidator);
        return new Grid(startingGrid);
    }

    private static int[] getIntegerPair(InputOutput io, Validator conwaysValidator) {
        String expression = io.getInput();
        while (!conwaysValidator.validInputString(expression)) {
            io.print(String.format("You entered %s. Please enter digits only, separated by a single space:", expression));
            expression = io.getInput();
        }
        return parseIntegerPair(expression);
    }

    private static boolean[][] addLiveStartingCells(boolean[][] startingGrid, InputOutput io, Validator conwaysValidator) {
        boolean finished = false;
        while (!finished) {
            startingGrid = addLiveCell(startingGrid, io, conwaysValidator);
            io.print(String.valueOf(Message.ENTER_ANOTHER_CELL));
            if(io.getInput().equals("n")) {
                finished = true;
            }
        }
        return startingGrid;
    }

    private static boolean[][] addLiveCell(boolean[][] startingGrid, InputOutput io, Validator conwaysValidator) {
        io.print(String.valueOf(Message.CELL));
        int[] cellLocation = getIntegerPair(io, conwaysValidator);
        while(!conwaysValidator.validCellLocation(cellLocation, startingGrid)) {
            io.print(String.valueOf(Message.INVALID_PLACEMENT));
            cellLocation = getIntegerPair(io, conwaysValidator);
        }
        startingGrid[cellLocation[1]-1][cellLocation[0]-1] = true;
        return startingGrid;
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