package com.ness;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest {

    private InputOutput io;
    private Calculator cellCalculator;

    @Before
    public void setUp() {
        this.io = new IO();
        this.cellCalculator = new Calculator();
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

        Grid currentState = new Grid(newWorld.io.getInitialState());

        assertNotNull(currentState);
    }

    @Test
    public void shouldBeAbleToRetrieveStateFromCurrentBoard() {
        World newWorld = new World(io);

        Grid currentState = new Grid(newWorld.io.getInitialState());
        boolean[][] result = currentState.getLiveCells();
        boolean[][] expected = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldCalculateNextStateFromCurrentState() {
        World newWorld = new World(io);

        Grid currentState = new Grid(newWorld.io.getInitialState());

        boolean[][] newState = cellCalculator.getNextTick(currentState.getLiveCells());
        boolean[][] expected = {{false, false, false, false}, {true, true, true, true}, {false, false, false, false}, {true, true, true, true}};

        currentState = new Grid(newState);
        boolean[][] result = currentState.getLiveCells();

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldSendStateToIOForDisplay() {
        IO io = new IO();
        World newWorld = new World(io);
        Grid currentState = new Grid(newWorld.io.getInitialState());
        newWorld.io.display(currentState.getLiveCells());

        boolean result = io.displayWasCalled;

        assertTrue(result);
    }

    class Calculator {

        boolean[][] getNextTick(boolean[][] currentState){
            return new boolean[][] {{false, false, false, false}, {true, true, true, true}, {false, false, false, false}, {true, true, true, true}};
        };

    }

    class IO implements com.ness.InputOutput {

        boolean displayWasCalled;

        public boolean[][] getInitialState() {
            boolean[][] initialLiveCells = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};
            return initialLiveCells;
        }

        public void display(boolean[][] state){
            this.displayWasCalled = true;
        };
    }

    class Grid {

        private final boolean[][] liveCells;

        Grid(boolean[][] initialState) {
            this.liveCells = initialState;
        }

        boolean[][] getLiveCells() { return this.liveCells;}
    }

}