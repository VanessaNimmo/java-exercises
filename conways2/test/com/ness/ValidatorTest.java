package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void shouldReturnTrueWhenAStringInPutMatchesTheRequiredPattern() {
        Validator conwaysValidator = new Validator(56);

        boolean result = conwaysValidator.validInputString("5 5");

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseWhenAStringInputDoesNotMatchTheRequiredPattern() {
        Validator conwaysValidator = new Validator(56);

        boolean result = conwaysValidator.validInputString("rtg 6");

        assertFalse(result);
    }

    @Test
    public void shouldLabelGridSizesBiggerThanMaxGridAsFalse() {
        int maxGrid = 56;
        Validator conwaysValidator = new Validator(56);
        int[] gridSize = {57, 34};

        boolean result = conwaysValidator.validGridSize(gridSize);

        assertFalse(result);
    }

    @Test
    public void shouldAcceptGridSizesSmallerThanMaxGridSize() {
        int maxGrid = 56;
        Validator conwaysValidator = new Validator(56);
        int[] gridSize = {25, 34};

        boolean result = conwaysValidator.validGridSize(gridSize);

        assertTrue(result);
    }

    @Test
    public void shouldRejectGridSizesOf0OrSmaller() {
        int maxGrid = 56;
        Validator conwaysValidator = new Validator(56);
        int[] gridSize = {-3, 34};

        boolean result = conwaysValidator.validGridSize(gridSize);

        assertFalse(result);
    }

    @Test
    public void shouldAcceptCellPlacementsInsideAGivenGrid() {
        int maxGrid = 56;
        Validator conwaysValidator = new Validator(56);
        boolean[][] emptyGrid = new boolean[10][10];
        int[] cellLocation = {3, 3};

        boolean result = conwaysValidator.validCellLocation(cellLocation, emptyGrid);

        assertTrue(result);
    }

    @Test
    public void shouldRejectCellPlacementOutsideAGivenGrid() {
        int maxGrid = 56;
        Validator conwaysValidator = new Validator(56);
        boolean[][] emptyGrid = new boolean[10][10];
        int[] cellLocation = {11, 3};

        boolean result = conwaysValidator.validCellLocation(cellLocation, emptyGrid);

        assertFalse(result);
    }

    @Test
    public void shouldRejectCellPlacementsBelow0() {
        int maxGrid = 56;
        Validator conwaysValidator = new Validator(56);
        boolean[][] emptyGrid = new boolean[10][10];
        int[] cellLocation = {0, 3};

        boolean result = conwaysValidator.validCellLocation(cellLocation, emptyGrid);

        assertFalse(result);
    }
}