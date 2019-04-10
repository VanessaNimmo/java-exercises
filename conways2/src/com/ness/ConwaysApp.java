package com.ness;

import com.ness.input.Coordinates;
import com.ness.input.FileParser;
import com.ness.input.InputDataSanitizer;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ConwaysApp {

    public static void main(String[] args) {

        int maxGridSize = Integer.parseInt(args[0]);
        int numberOfTicks = Integer.parseInt(args[1]);
        int sleepTime = Integer.parseInt(args[2]);
        String filePath = args[3];

        File setupFile = new File(filePath);
        IOutput output = new ConsoleOutput();
        FileParser readFile = new FileParser(setupFile);
        Optional<ArrayList<Coordinates>> initialStateOptional = readFile.getCoordinatesList();
        if (initialStateOptional.isEmpty()) {
            exitWithErrors(output);
        }
        ArrayList<Coordinates> coordinatesList = initialStateOptional.get();

        InputDataSanitizer sanitizer = new InputDataSanitizer(maxGridSize);
        int gridWidth = 0, gridHeight = 0;
        if (sanitizer.checkGridSize(coordinatesList)) {
            gridWidth = coordinatesList.get(0).getX();
            gridHeight = coordinatesList.get(0).getY();
            coordinatesList = (ArrayList<Coordinates>) sanitizer.removeInvalidCoordinatePairs(coordinatesList);
        } else {
            exitWithErrors(output);
        }
        ArrayList<Cell> initialCellList = getCellList(coordinatesList);

        IGrid initialGrid = new Grid2D(initialCellList, gridHeight, gridWidth);
        IGridCalculator calculator = new GridCalculator();

        ResourceBundle messages = ResourceBundle.getBundle("messages");
        String welcome = messages.getString("welcome");
        output.print(welcome);

        World game = new World(initialGrid, numberOfTicks, sleepTime, output, calculator);
        game.run();
    }

    private static ArrayList<Cell> getCellList(ArrayList<Coordinates> coordinatesList) {
        return coordinatesList.stream().map(coordinate -> new Cell(new Location(coordinate.getY() - 1, coordinate.getX() - 1), true)).collect(Collectors.toCollection(ArrayList::new));
    };

    private static void exitWithErrors(IOutput output) {
        ResourceBundle messages = ResourceBundle.getBundle("messages");
        String invalid = messages.getString("invalid");
        output.print(invalid);
        System.exit(0);
    }
}