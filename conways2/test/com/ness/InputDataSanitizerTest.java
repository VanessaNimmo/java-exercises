package com.ness;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class InputDataSanitizerTest {

    @Test
    public void aCoordinateListOfOneShouldReturnTrueIfBothNumbersSmallerThanMaxGridSize() {
        int maxGridSize = 56;
        ArrayList<Coordinates> coordinatesList = new ArrayList<>();
        coordinatesList.add(new Coordinates(10,10));
        InputDataSanitizer validator = new InputDataSanitizer(maxGridSize, coordinatesList);

        boolean result = validator.check();

        assertTrue(result);
    }

    @Test
    public void aCoordinateListOfOneShouldReturnFalseIfANumberIsLargerThanMaxGridSize() {
        int maxGridSize = 56;
        ArrayList<Coordinates> coordinatesList = new ArrayList<>();
        coordinatesList.add(new Coordinates(100,10));
        InputDataSanitizer validator = new InputDataSanitizer(maxGridSize, coordinatesList);

        boolean result = validator.check();

        assertFalse(result);
    }

    @Test
    public void aCoordinateListOfOneShouldReturnFalseIfFirstNumberIsLessThanZero() {
        int maxGridSize = 56;
        ArrayList<Coordinates> coordinatesList = new ArrayList<>();
        coordinatesList.add(new Coordinates(-1,10));
        InputDataSanitizer validator = new InputDataSanitizer(maxGridSize, coordinatesList);

        boolean result = validator.check();

        assertFalse(result);

    }

    @Test
    public void aCoordinateListOfOneShouldReturnFalseIfSecondNumberIsLessThanZero() {
        int maxGridSize = 56;
        ArrayList<Coordinates> coordinatesList = new ArrayList<>();
        coordinatesList.add(new Coordinates(10,-10));
        InputDataSanitizer validator = new InputDataSanitizer(maxGridSize, coordinatesList);

        boolean result = validator.check();

        assertFalse(result);
    }

    @Test
    public void subsequentCoordinatesShouldBeAcceptedIfXCoordinateIsSmallerThanSuppliedGridWidth() {
        int maxGridSize = 56;
        ArrayList<Coordinates> coordinatesList = new ArrayList<>();
        coordinatesList.add(new Coordinates(10,10));
        coordinatesList.add(new Coordinates(5,10));

        InputDataSanitizer validator = new InputDataSanitizer(maxGridSize, coordinatesList);

        ArrayList<Coordinates> result = (ArrayList<Coordinates>) validator.removeInvalidCoordinatePairs(coordinatesList);

        assertTrue(result.size() == 1);
    }

    @Test
    public void shouldRemoveCoordinatesOutsideTheSuppliedGrid() {
        int maxGridSize = 56;
        ArrayList<Coordinates> coordinatesList = new ArrayList<>();
        coordinatesList.add(new Coordinates(10,10));
        coordinatesList.add(new Coordinates(11,10));

        InputDataSanitizer validator = new InputDataSanitizer(maxGridSize, coordinatesList);

        ArrayList<Coordinates> result = (ArrayList<Coordinates>) validator.removeInvalidCoordinatePairs(coordinatesList);

        assertTrue(result.size() == 0);
    }

    @Test
    public void shouldRemoveCoordinatesBelow0() {
        int maxGridSize = 56;
        ArrayList<Coordinates> coordinatesList = new ArrayList<>();
        coordinatesList.add(new Coordinates(10,10));
        coordinatesList.add(new Coordinates(-1,10));

        InputDataSanitizer validator = new InputDataSanitizer(maxGridSize, coordinatesList);

        ArrayList<Coordinates> result = (ArrayList<Coordinates>) validator.removeInvalidCoordinatePairs(coordinatesList);

        assertTrue(result.size() == 0);
    }

}