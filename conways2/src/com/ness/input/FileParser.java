package com.ness.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {

    private final File initialGridInfo;

    public FileParser(File initialGridInfo) {
        this.initialGridInfo = initialGridInfo;
    }

    public Optional<ArrayList<Coordinates>> getCoordinatesList() {
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
        return Optional.of(coordinatesList);
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
}