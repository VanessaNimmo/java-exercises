package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest {

    @Test
    public void shouldAcceptInitialStateFromAUser() {
        InputOutput io = new IO();
        World newWorld = new World(io);

        boolean[][] result = newWorld.io.getInitialState();

        boolean[][] expected = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};

        assertArrayEquals(expected, result);
    }

    class IO implements com.ness.InputOutput {

        public boolean[][] getInitialState() {
            boolean[][] initialLiveCells = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};
            return initialLiveCells;
        }
    }

}