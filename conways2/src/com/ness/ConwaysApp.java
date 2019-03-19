package com.ness;

import java.io.File;
import java.util.ArrayList;

public class ConwaysApp {

    public static void main(String[] args) {

        int maxGridSize = Integer.parseInt(args[0]);
        int numberOfTicks = Integer.parseInt(args[1]);
        int sleepTime = Integer.parseInt(args[2]);
        String filePath = args[3];
        File setupFile = new File(filePath);

        Output output = new ConsoleOutput();
        Calculator tickCalculator = new TickCalculator();
        Validator conwaysValidator = new Validator(maxGridSize);
        FileReader readFile = new FileReader(setupFile);
        Grid initialState = readFile.getInitialState(conwaysValidator);

        output.print(String.valueOf(Message.WELCOME));

        Conways game = new Conways(initialState, numberOfTicks, sleepTime, output, tickCalculator);
        game.run();
    }

    private static Grid getInitialState(Output io, Validator conwaysValidator) {
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

    private static int[] getIntegerPair(Output io, Validator conwaysValidator) {
        // Need to get integer pairs from the arguments passed to the program now
        String expression = "1 1";
        while (!conwaysValidator.validInputString(expression)) {
            io.print(String.format("You entered %s. ", expression));
            io.print(String.valueOf(Message.INPUT_RULES));
            expression = "1 1";
        }
        return parseIntegerPair(expression);
    }

    private static boolean[][] addLiveStartingCells(boolean[][] startingGrid, Output io, Validator conwaysValidator) {
        boolean finished = false;
        while (!finished) {
            startingGrid = addLiveCell(startingGrid, io, conwaysValidator);
            io.print(String.valueOf(Message.ENTER_ANOTHER_CELL));
//            if(io.getInput().equals("n")) {
                finished = true;
//            }
        }
        return startingGrid;
    }

    private static boolean[][] addLiveCell(boolean[][] startingGrid, Output io, Validator conwaysValidator) {
        io.print(String.valueOf(Message.CELL));
        int[] cellLocation = getIntegerPair(io, conwaysValidator);
        while(!conwaysValidator.validCellLocation(cellLocation, startingGrid)) {
            io.print(String.valueOf(Message.INVALID_PLACEMENT));
            cellLocation = getIntegerPair(io, conwaysValidator);
        }
        startingGrid[cellLocation[1]-1][cellLocation[0]-1] = true;
        return startingGrid;
    }

    // This doesn't belong in the game class - could be in the validator, or could be in its own parser thing, or in some class you have not yet discovered!
    private static int[] parseIntegerPair(String expression) {
        String[] splitInput = expression.split(" ");
        int[] integerPair = new int[2];
        for (int i=0; i < 2; i++) {
            integerPair[i] = Integer.parseInt(splitInput[i]);
        }
        return integerPair;
    }
}