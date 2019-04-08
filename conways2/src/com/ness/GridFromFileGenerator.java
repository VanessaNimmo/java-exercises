package com.ness;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GridFromFileGenerator {

    private final File initialGridInfo;
    private final int maxGridSize;

    GridFromFileGenerator(File initialGridInfo, int maxGridSize) {
        this.initialGridInfo = initialGridInfo;
        this.maxGridSize = maxGridSize;
    }

    Optional<Grid2D> getInitialState() {
        String line = null;
        ArrayList<int[]> numberPairs = new ArrayList<>();
        try (FileReader fileReader = new FileReader(initialGridInfo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                if (validInputString(line)) {
                    numberPairs.add(parseIntegerPair(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (numberPairs.isEmpty()) {
            return Optional.empty();
        }
        int[] gridSize = numberPairs.get(0);
        if (!validGridSize(gridSize)) {
            return Optional.empty();
        }
        numberPairs.remove(0);
        boolean[][] initialState = new boolean[gridSize[0]][gridSize[1]];
        if(numberPairs.size() >= 1) {
            initialState = addLiveCells(numberPairs, initialState);
        }
        Grid2D initialStateGrid = new Grid2D(initialState);
        return Optional.of(initialStateGrid);
    }

    private boolean[][] addLiveCells(ArrayList<int[]> numberPairs, boolean[][] initialState) {
        numberPairs.stream().filter(pair -> validCellLocation(pair, initialState)).forEach(pair -> initialState[pair[1] - 1][pair[0] - 1] = true);
        return initialState;
    }

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

    private boolean validGridSize(int[] gridSize) {
        if (gridSize[0] <=0 || gridSize[1] <= 0) {
            return false;
        }
        return (gridSize[0] < maxGridSize && gridSize[1] < maxGridSize);
    }

    private boolean validCellLocation(int[] cellLocation, boolean[][] grid) {
        if (cellLocation[0] <= 0 || cellLocation[1] <= 0 || cellLocation[1] > grid.length || cellLocation[0] > grid[0].length) {
            return false;
        }
        return true;
    }
}
