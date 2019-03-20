package com.ness;

import java.io.File;
import java.util.ResourceBundle;

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
        FileParser readFile = new FileParser(setupFile, conwaysValidator);
        Grid initialState = readFile.getInitialState();

        ResourceBundle messages = ResourceBundle.getBundle("messages");
        String welcome = messages.getString("welcome");
        output.print(welcome);

        Conways game = new Conways(initialState, numberOfTicks, sleepTime, output, tickCalculator);
        game.run();
    }

//    private static Grid getInitialState(Output io, Validator conwaysValidator) {
//
//        boolean[][] emptyGrid = new boolean[gridSize[0]][gridSize[1]];
//        boolean[][] startingGrid = addLiveStartingCells(emptyGrid, io, conwaysValidator);
//        return new Grid(startingGrid);
//    }

//    private static boolean[][] addLiveCell(boolean[][] startingGrid, Output io, Validator conwaysValidator) {
//        io.print(String.valueOf(Message.CELL));
//        int[] cellLocation = getIntegerPair(io, conwaysValidator);
//        while(!conwaysValidator.validCellLocation(cellLocation, startingGrid)) {
//            io.print(String.valueOf(Message.INVALID_PLACEMENT));
//            cellLocation = getIntegerPair(io, conwaysValidator);
//        }
//        startingGrid[cellLocation[1]-1][cellLocation[0]-1] = true;
//        return startingGrid;
//    }
}