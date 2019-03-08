package com.ness;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest {

    private InputOutput io;

    @Before
    public void setUp() {
        this.io = new IO();
    }

    @Test
    public void shouldAcceptInitialStateFromAUser() {
        World newWorld = new World(io);

        boolean[][] result = newWorld.io.getInitialState();

        boolean[][] expected = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldMakeNewWorldRepresentationFromInitialState() {
        World newWorld = new World(io);

        Board currentState = new Board(newWorld.io.getInitialState());

        assertNotNull(currentState);
    }

    @Test
    public void shouldBeAbleToRetrieveStateFromCurrentBoard() {
        World newWorld = new World(io);

        Board currentState = new Board(newWorld.io.getInitialState());
        boolean[][] result = currentState.getLiveCells();
        boolean[][] expected = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};

        assertArrayEquals(expected, result);
    }

    class IO implements com.ness.InputOutput {

        public boolean[][] getInitialState() {
            boolean[][] initialLiveCells = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};
            return initialLiveCells;
        }
    }

    class Board {

        private final boolean[][] liveCells;

        Board(boolean[][] initialState) {
            this.liveCells = initialState;
        }

        boolean[][] getLiveCells() { return this.liveCells;}
    }

}