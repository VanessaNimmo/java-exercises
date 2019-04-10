package com.ness;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputDataSanitizer {

    private int maxGridSize;
    private ArrayList<Coordinates> coordinatesList;
    
    InputDataSanitizer(int maxGridSize, ArrayList<Coordinates> coordinatesList) {
        this.maxGridSize = maxGridSize;
        this.coordinatesList = coordinatesList;
    }

    public boolean check() {
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
