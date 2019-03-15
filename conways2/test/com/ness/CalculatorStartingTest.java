package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorStartingTest {

    @Test
    public void shouldReturnANewLiveCellCollectionFromOldCellCollection() {
        CalculatorStarting cellCalculator = new CalculatorStarting();
        boolean[][] initialState = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};

        boolean[][] result = cellCalculator.getNextTick(new Grid(initialState)).getLiveCells();
        boolean[][] expected = {{false, false, false, false}, {true, true, true, true}, {false, false, false, false}, {true, true, true, true}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnNewLiveCellCollectionDifferentScenario() {
        CalculatorStarting cellCalculator = new CalculatorStarting();
        boolean[][] initialState = {{false, true, false, false}, {false, true, true, false}, {false, false, false, false}, {false, true, false, false}};

        boolean[][] result = cellCalculator.getNextTick(new Grid(initialState)).getLiveCells();
        boolean[][] expected = {{true, true, false, false}, {false, true, true, false}, {false, true, true, false}, {false, false, false, false}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void whenGivenThreeLiveCellsInLShapeShouldReturnThat4thCellHasComeAlive() {
        CalculatorStarting cellCalculator = new CalculatorStarting();
        boolean[][] initialState = {{false, false, false, false, false}, {false, true, true, false, false}, {false, true, false, false, false}, {false, false, false, false, false}};

        boolean[][] result = cellCalculator.getNextTick(new Grid(initialState)).getLiveCells();
        boolean[][] expected = {{false, false, false, false, false}, {false, true, true, false, false}, {false, true, true, false, false}, {false, false, false, false, false}};

        assertArrayEquals(expected, result);
    }

}