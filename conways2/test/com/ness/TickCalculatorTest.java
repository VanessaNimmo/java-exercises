package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class TickCalculatorTest {

    @Test
    public void shouldReturnANewLiveCellCollectionFromOldCellCollection() {
        TickCalculator cellCalculator = new TickCalculator();
        boolean[][] initialState = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};

        boolean[][] result = cellCalculator.getNextTick(new Grid(initialState)).getCells();
        boolean[][] expected = {{false, false, false, false}, {true, true, true, true}, {false, false, false, false}, {true, true, true, true}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnNewLiveCellCollectionDifferentScenario() {
        TickCalculator cellCalculator = new TickCalculator();
        boolean[][] initialState = {{false, true, false, false}, {false, true, true, false}, {false, false, false, false}, {false, true, false, false}};

        boolean[][] result = cellCalculator.getNextTick(new Grid(initialState)).getCells();
        boolean[][] expected = {{true, true, false, false}, {false, true, true, false}, {false, true, true, false}, {false, false, false, false}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void whenGivenThreeLiveCellsInLShapeShouldReturnThat4thCellHasComeAlive() {
        TickCalculator cellCalculator = new TickCalculator();
        boolean[][] initialState = {{false, false, false, false, false}, {false, true, true, false, false}, {false, true, false, false, false}, {false, false, false, false, false}};

        boolean[][] result = cellCalculator.getNextTick(new Grid(initialState)).getCells();
        boolean[][] expected = {{false, false, false, false, false}, {false, true, true, false, false}, {false, true, true, false, false}, {false, false, false, false, false}};

        assertArrayEquals(expected, result);
    }

}