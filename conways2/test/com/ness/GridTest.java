package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {

    @Test
    public void shouldReturnANewLiveCellCollectionFromOldCellCollection() {
        boolean[][] initialState = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};

        Grid initial = new Grid(initialState);
        Grid nextTick = new Grid(initial);

        boolean[][] result = nextTick.getCells();
        boolean[][] expected = {{false, false, false, false}, {true, true, true, true}, {false, false, false, false}, {true, true, true, true}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldReturnNewLiveCellCollectionDifferentScenario() {
        boolean[][] initialState = {{false, true, false, false}, {false, true, true, false}, {false, false, false, false}, {false, true, false, false}};

        Grid initial = new Grid(initialState);
        Grid nextTick = new Grid(initial);

        boolean[][] result = nextTick.getCells();
        boolean[][] expected = {{true, true, false, false}, {false, true, true, false}, {false, true, true, false}, {false, false, false, false}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void whenGivenThreeLiveCellsInLShapeShouldReturnThat4thCellHasComeAlive() {
        boolean[][] initialState = {{false, false, false, false, false}, {false, true, true, false, false}, {false, true, false, false, false}, {false, false, false, false, false}};

        Grid initial = new Grid(initialState);
        Grid nextTick = new Grid(initial);

        boolean[][] result = nextTick.getCells();
        boolean[][] expected = {{false, false, false, false, false}, {false, true, true, false, false}, {false, true, true, false, false}, {false, false, false, false, false}};

        assertArrayEquals(expected, result);
    }

}