package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void shouldReturnANewLiveCellCollectionFromOldCellCollection() {
        Calculator cellCalculator = new Calculator();
        boolean[][] initialState = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};

        boolean[][] result = cellCalculator.getNextTick(initialState);
        boolean[][] expected = {{false, false, false, false}, {true, true, true, true}, {false, false, false, false}, {true, true, true, true}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnNewLiveCellCollectionDifferentScenario() {
        Calculator cellCalculator = new Calculator();
        boolean[][] initialState = {{false, true, false, false}, {false, true, true, false}, {false, false, false, false}, {false, true, false, false}};

        boolean[][] result = cellCalculator.getNextTick(initialState);
        boolean[][] expected = {{true, true, false, false}, {false, true, true, false}, {false, true, true, false}, {false, false, false, false}};

        assertArrayEquals(expected, result);
    }

}