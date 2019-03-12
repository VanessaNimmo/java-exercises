package com.ness;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest {

    private IOStub io;
    private CalculatorStub cellCalculatorStub;

    @Before
    public void setUp() {
        this.io = new IOStub();
        this.cellCalculatorStub = new CalculatorStub();
    }

    @Test
    public void shouldAcceptInitialStateFromAUser() {
        World newWorld = new World(io, 1, cellCalculatorStub);

        boolean[][] result = newWorld.io.getInitialState();

        boolean[][] expected = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldMakeNewWorldRepresentationFromInitialState() {
        World newWorld = new World(io, 1, cellCalculatorStub);

        GridStub currentState = new GridStub(newWorld.io.getInitialState());

        assertNotNull(currentState);
    }

    @Test
    public void shouldBeAbleToRetrieveStateFromCurrentBoard() {
        World newWorld = new World(io, 1, cellCalculatorStub);

        GridStub currentState = new GridStub(newWorld.io.getInitialState());
        boolean[][] result = currentState.getLiveCells();
        boolean[][] expected = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldCalculateNextStateFromCurrentState() {
        World newWorld = new World(io, 1, cellCalculatorStub);

        GridStub currentState = new GridStub(newWorld.io.getInitialState());

        boolean[][] newState = cellCalculatorStub.getNextTick(currentState.getLiveCells());
        boolean[][] expected = {{false, false, false, false}, {true, true, true, true}, {false, false, false, false}, {true, true, true, true}};

        currentState = new GridStub(newState);
        boolean[][] result = currentState.getLiveCells();

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldSendStateToIOForDisplay() {
        World newWorld = new World(io, 1, cellCalculatorStub);
        GridStub currentState = new GridStub(newWorld.io.getInitialState());
        newWorld.io.display(currentState.getLiveCells());

        boolean result = io.displayWasCalled;

        assertTrue(result);
    }

    @Test
    public void shouldSendAPredefinedNumberOfBoardsToTheIOThenEndGame() {
        int numberOfTicks = 5;
        World newWorld = new World(io, numberOfTicks, cellCalculatorStub);

        newWorld.run();

        int result = io.displayCount;

        assertEquals(5, result);
    }
}