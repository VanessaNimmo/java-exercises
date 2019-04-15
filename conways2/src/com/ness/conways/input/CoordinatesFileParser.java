package com.ness.conways.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class CoordinatesFileParser {

    private static final String COORDINATES_LINE_REGEX = "\\d*\\s\\d*";

    private final File initialGridInfo;

    public CoordinatesFileParser(File initialGridInfo) {
        this.initialGridInfo = initialGridInfo;
    }

    public Optional<ArrayList<Coordinates>> getCoordinatesList() {
        String line;
        ArrayList<Coordinates> coordinatesList = new ArrayList<>();
        try (FileReader fileReader = new FileReader(initialGridInfo);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while ((line = bufferedReader.readLine()) != null) {
                if (isCoordinateLineValid(line)) {
                    coordinatesList.add(getCoordinatesFromLine(line));
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

    private static Coordinates getCoordinatesFromLine(String line) {
        String[] splitInput = line.split(" ");
        int[] integerPair = new int[2];
        for (int i=0; i < 2; i++) {
            integerPair[i] = Integer.parseInt(splitInput[i]);
        }
        return new Coordinates(integerPair[0], integerPair[1]);
    }

    private boolean isCoordinateLineValid(String line) {
        return line.matches(COORDINATES_LINE_REGEX);
    }
}