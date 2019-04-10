package com.ness;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileParser {

    private final File initialGridInfo;

    FileParser(File initialGridInfo) {
        this.initialGridInfo = initialGridInfo;
    }

    Optional<ArrayList<Coordinates>> getCoordinatesList() {
        String line = null;
        int[] numberPair;
        ArrayList<Coordinates> coordinatesList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(initialGridInfo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                if (validInputString(line)) {
                    numberPair = parseIntegerPair(line);
                    coordinatesList.add(new Coordinates(numberPair[0], numberPair[1]));
                } else {
                    return Optional.empty();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (coordinatesList.isEmpty()) {
            return Optional.empty();
        }
//        int[] gridSize = numberPairs.get(0);
//        if (!validGridSize(gridSize)) {
//            return Optional.empty();
//        }
        ;
//        boolean[][] initialState = new boolean[gridSize[0]][gridSize[1]];
//        if(numberPairs.size() >= 1) {
//            initialState = addLiveCells(numberPairs, initialState);
//        }

        return Optional.of(coordinatesList);
    }

//    private boolean[][] addLiveCells(ArrayList<int[]> numberPairs, boolean[][] initialState) {
//        numberPairs.stream().filter(pair -> validCellLocation(pair, initialState[0].length, initialState.length)).forEach(pair -> initialState[pair[1] - 1][pair[0] - 1] = true);
//        return initialState;
//    }

    private static int[] parseIntegerPair(String expression) {
        String[] splitInput = expression.split(" ");
        int[] integerPair = new int[2];
        for (int i=0; i < 2; i++) {
            integerPair[i] = Integer.parseInt(splitInput[i]);
        }
        return integerPair;
    }

    private boolean validInputString(String s) {
        Pattern numberPair = Pattern.compile("\\d*\\s\\d*");
        Matcher matcher = numberPair.matcher(s);
        return matcher.matches();
    }

//    private boolean validGridSize(int[] gridSize) {
//        if (gridSize[0] <=0 || gridSize[1] <= 0) {
//            return false;
//        }
//        return (gridSize[0] < maxGridSize && gridSize[1] < maxGridSize);
//    }

//    private boolean validCellLocation(int[] cellLocation, int gridWidth, int gridHeight) {
//        if (cellLocation[0] <= 0 || cellLocation[1] <= 0 || cellLocation[0] > gridWidth || cellLocation[1] > gridHeight) {
//            return false;
//        }
//        return true;
//    }
}
