package com.ness;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class FileParser {

    private final File initialGridInfo;
    private final Validator validator;

    FileParser(File initialGridInfo, Validator conwaysValidator) {
        this.initialGridInfo = initialGridInfo;
        this.validator = conwaysValidator;
    }

    Grid getInitialState() {
        String line = null;
        ArrayList<int[]> numberPairs = new ArrayList<>();
        try (FileReader fileReader = new FileReader(initialGridInfo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                if (validator.validInputString(line)) {
                    numberPairs.add(parseIntegerPair(line));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] gridSize = numberPairs.get(0);
        numberPairs.remove(0);
        boolean[][] initialState = new boolean[gridSize[0]][gridSize[1]];
        if(numberPairs.size() >= 1) {
            initialState = addLiveCells(numberPairs, initialState);
        }
        return new Grid(initialState);
    }

    private boolean[][] addLiveCells(ArrayList<int[]> numberPairs, boolean[][] initialState) {
        numberPairs.forEach((pair) -> {
            if (validator.validCellLocation(pair, initialState)) {
                initialState[pair[1]-1][pair[0]-1] = true;
            }
        });
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
}
