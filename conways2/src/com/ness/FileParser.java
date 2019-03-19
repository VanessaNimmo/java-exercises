package com.ness;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        try {
            FileReader fileReader = new FileReader(initialGridInfo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                if(validator.validInputString(line)) {
                    numberPairs.add(parseIntegerPair(line));
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        int[] gridSize = numberPairs.get(0);
        return new Grid(new boolean[gridSize[0]][gridSize[1]]);
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
