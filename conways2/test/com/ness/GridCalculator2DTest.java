package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridCalculator2DTest {

    @Test
    public void shouldCalculateANewLiveCellCollectionFromOldCellCollection() {
        boolean[][] initialState = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};
        GridCalculator2D calculator2D = new GridCalculator2D();

        Grid2D initial = new Grid2D(initialState);
        Grid2D nextTick = calculator2D.getNextTick(initial);

        boolean[][] result = nextTick.getCells();
        boolean[][] expected = {{false, false, false, false}, {true, true, true, true}, {false, false, false, false}, {true, true, true, true}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnNewLiveCellCollectionDifferentScenario() {
        boolean[][] initialState = {{false, true, false, false}, {false, true, true, false}, {false, false, false, false}, {false, true, false, false}};
        GridCalculator2D calculator2D = new GridCalculator2D();

        Grid2D initial = new Grid2D(initialState);
        Grid2D nextTick = calculator2D.getNextTick(initial);

        boolean[][] result = nextTick.getCells();
        boolean[][] expected = {{true, true, false, false}, {false, true, true, false}, {false, true, true, false}, {false, false, false, false}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void whenGivenThreeLiveCellsInLShapeShouldReturnThat4thCellHasComeAlive() {
        boolean[][] initialState = {{false, false, false, false, false}, {false, true, true, false, false}, {false, true, false, false, false}, {false, false, false, false, false}};
        GridCalculator2D calculator2D = new GridCalculator2D();

        Grid2D initial = new Grid2D(initialState);
        Grid2D nextTick = calculator2D.getNextTick(initial);

        boolean[][] result = nextTick.getCells();
        boolean[][] expected = {{false, false, false, false, false}, {false, true, true, false, false}, {false, true, true, false, false}, {false, false, false, false, false}};

        assertArrayEquals(expected, result);
    }

}