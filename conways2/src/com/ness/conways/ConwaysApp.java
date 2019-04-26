package com.ness.conways;

import com.ness.conways.grid.*;
import com.ness.conways.input.*;
import com.ness.conways.output.*;
import com.ness.conways.input.CoordinatesFileParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ConwaysApp {

    private static final String MESSAGES_FILE_PATH = "com/ness/conways/messages";

    public static void main(String[] args) {

        int maxGridSizeForOutput = Integer.parseInt(args[0]);
        int numberOfTicks = Integer.parseInt(args[1]);
        int sleepTime = Integer.parseInt(args[2]);
        String filePath = args[3];

        IOutput output = new ConsoleOutput();
        ResourceBundle messages = ResourceBundle.getBundle(MESSAGES_FILE_PATH);
        String welcome = messages.getString("welcome");
        output.print(welcome);
        File setupFile = new File(filePath);
        ArrayList<Coordinates> coordinatesList = extractCoordinatesList(setupFile, output);
        InputDataSanitizer sanitizer = new InputDataSanitizer(maxGridSizeForOutput);
        IGrid initialGrid = makeInitialGrid(sanitizer, coordinatesList, output);
        IGridCalculator calculator = new GridCalculator();

        World game = new World(initialGrid, numberOfTicks, sleepTime, output, calculator);
        game.run();
    }

    private static ArrayList<Coordinates> extractCoordinatesList(File setupFile, IOutput output) {
        CoordinatesFileParser readFile = new CoordinatesFileParser(setupFile);
        Optional<ArrayList<Coordinates>> initialStateOptional = readFile.getCoordinatesList();
        if (initialStateOptional.isEmpty()) {
            exitWithErrors(output);
        }
        return initialStateOptional.get();
    }

    private static IGrid makeInitialGrid(InputDataSanitizer sanitizer, ArrayList<Coordinates> coordinatesList, IOutput output) {
        int gridWidth = 0, gridHeight = 0;
        if (sanitizer.checkGridSize(coordinatesList)) {
            gridWidth = coordinatesList.get(0).getX();
            gridHeight = coordinatesList.get(0).getY();
            coordinatesList = (ArrayList<Coordinates>) sanitizer.removeInvalidCoordinatePairs(coordinatesList);
        } else {
            exitWithErrors(output);
        }
        ArrayList<Cell> initialLiveCellList = convertCoordinatesToLiveCells(coordinatesList);
        ArrayList<Cell> fullCellList = addDeadCells(initialLiveCellList, gridHeight, gridWidth);
        return new Grid2D(fullCellList, gridHeight, gridWidth);
    }

    private static ArrayList<Cell> addDeadCells(ArrayList<Cell> initialLiveCellList, int gridHeight, int gridWidth) {
        ArrayList<Cell> allCellsList = new ArrayList<>();
        for (int row = 0; row < gridHeight; row ++) {
            for (int column = 0; column < gridWidth; column++) {
                if (cellIsInList(initialLiveCellList, row, column)) {
                    allCellsList.add(new Cell(new Location(row, column), LifeType.ALIVE));
                } else {
                    allCellsList.add(new Cell(new Location(row, column), LifeType.DEAD));
                }
            }
        }
        return allCellsList;
    }

    private static boolean cellIsInList(ArrayList<Cell> initialLiveCellList, int row, int column) {
        return initialLiveCellList.stream().anyMatch(cell -> cell.getLocation().getRow() == row && cell.getLocation().getColumn() == column);
    }

    private static ArrayList<Cell> convertCoordinatesToLiveCells(ArrayList<Coordinates> coordinatesList) {
        return coordinatesList.stream().map(coordinate -> new Cell(new Location(coordinate.getY() - 1, coordinate.getX() - 1), LifeType.ALIVE)).collect(Collectors.toCollection(ArrayList::new));
    }

    private static void exitWithErrors(IOutput output) {
        ResourceBundle messages = ResourceBundle.getBundle(MESSAGES_FILE_PATH);
        String invalid = messages.getString("invalid");
        output.print(invalid);
        System.exit(0);
    }
}