package com.ness.input;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputDataSanitizer {

    private int maxGridSize;

    public InputDataSanitizer(int maxGridSize) {
        this.maxGridSize = maxGridSize;
    }

    public boolean checkGridSize(ArrayList<Coordinates> coordinatesList) {
        return validGridSize(coordinatesList.get(0).getX(), coordinatesList.get(0).getY());
    }

    public List<Coordinates> removeInvalidCoordinatePairs(ArrayList<Coordinates> coordinatesList) {
        int gridWidth = coordinatesList.get(0).getX();
        int gridHeight = coordinatesList.get(0).getY();
        coordinatesList.remove(0);
        return coordinatesList.stream().filter(coordinates -> validCellLocation(coordinates, gridWidth, gridHeight)).collect(Collectors.toList());
    }

    private boolean validGridSize(int gridWidth, int gridHeight) {
        if (gridWidth <=0 || gridHeight <= 0) {
            return false;
        }
        return (gridWidth < maxGridSize && gridHeight < maxGridSize);
    }


    private boolean validCellLocation(Coordinates cellLocation, int gridWidth, int gridHeight) {
        if (cellLocation.getX() <= 0 || cellLocation.getY() <= 0 || cellLocation.getX() > gridWidth || cellLocation.getY() > gridHeight) {
            return false;
        }
        return true;
    }
}
