package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridCalculator2DTest {

    // TODO Rewrite these tests to reflect the new file structure but implementing the same behaviour, and add the functionality to the GridCalculator2D as you go. Consider interator options.
    @Test
    public void shouldReturnANewLiveCellCollectionFromOldCellCollection() {
        boolean[][] initialState = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};

        Grid2D initial = new Grid2D(initialState);
        Grid2D nextTick = new Grid2D(initial.getCells());

        boolean[][] result = nextTick.getCells();
        boolean[][] expected = {{false, false, false, false}, {true, true, true, true}, {false, false, false, false}, {true, true, true, true}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnNewLiveCellCollectionDifferentScenario() {
        boolean[][] initialState = {{false, true, false, false}, {false, true, true, false}, {false, false, false, false}, {false, true, false, false}};

        Grid2D initial = new Grid2D(initialState);
        Grid2D nextTick = new Grid2D(initial.getCells());

        boolean[][] result = nextTick.getCells();
        boolean[][] expected = {{true, true, false, false}, {false, true, true, false}, {false, true, true, false}, {false, false, false, false}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void whenGivenThreeLiveCellsInLShapeShouldReturnThat4thCellHasComeAlive() {
        boolean[][] initialState = {{false, false, false, false, false}, {false, true, true, false, false}, {false, true, false, false, false}, {false, false, false, false, false}};

        Grid2D initial = new Grid2D(initialState);
        Grid2D nextTick = new Grid2D(initial.getCells());

        boolean[][] result = nextTick.getCells();
        boolean[][] expected = {{false, false, false, false, false}, {false, true, true, false, false}, {false, true, true, false, false}, {false, false, false, false, false}};

        assertArrayEquals(expected, result);
    }

}