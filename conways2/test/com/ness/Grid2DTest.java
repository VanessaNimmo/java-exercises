package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class Grid2DTest {

    // TODO Need to test both cases of the one cell option, as well as both the true and false versions of the aliveNeighbours one. Find the edge cases and test those (esp. on aliveNeighbours)
    @Test
    public void cellIsAliveShouldReturnTrueForAOneByOneGridOfALiveCell() {
        boolean[][] liveCells = {{true}};
        Grid2D grid = new Grid2D(liveCells);

        boolean result = grid.cellIsAlive(1, 1);

        assertTrue(result);
    }

    @Test
    public void aliveNeighboursShouldReturnNumberOfAliveNeighbours() {
        boolean[][] liveCells = {{true, true}, {false, false}};
        Grid2D grid = new Grid2D(liveCells);

        int result = grid.aliveNeighbours(1, 1);

        assertEquals(2, result);
    }

}