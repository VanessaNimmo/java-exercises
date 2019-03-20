package com.ness;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Validator {

    private int maxGridSize;

    Validator(int maxGridSize) {
        this.maxGridSize = maxGridSize;
    }

    boolean validInputString(String s) {
        Pattern numberPair = Pattern.compile("\\d*\\s\\d*");
        Matcher matcher = numberPair.matcher(s);
        return matcher.matches();
    }

    boolean validGridSize(int[] gridSize) {
        if (gridSize[0] <=0 || gridSize[1] <= 0) {
            return false;
        }
        return (gridSize[0] < maxGridSize && gridSize[1] < maxGridSize);
    }

    boolean validCellLocation(int[] cellLocation, boolean[][] grid) {
        if (cellLocation[0] <= 0 || cellLocation[1] <= 0) {
            return false;
        }
        return (cellLocation[1] <= grid.length && cellLocation[0] <= grid[0].length);
    }
}
