//package com.ness;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class WorldTest {
//
//    private IOStub io;
//    private Calculator cellCalculatorStub;
//
//    @Before
//    public void setUp() {
//        this.io = new IOStub();
//        this.cellCalculatorStub = new CalculatorStub();
//    }
//
//    @Test
//    public void shouldAcceptInitialStateFromAUser() {
//        World newWorld = new World(io, 1, cellCalculatorStub, 500);
//
//        boolean[][] result = newWorld.io.getInitialState();
//
//        boolean[][] expected = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};
//
//        assertArrayEquals(expected, result);
//    }
//
//    @Test
//    public void shouldMakeNewWorldRepresentationFromInitialState() {
//        World newWorld = new World(io, 1, cellCalculatorStub, 500);
//
//        GridStub currentState = new GridStub(newWorld.io.getInitialState());
//
//        assertNotNull(currentState);
//    }
//
//    @Test
//    public void shouldBeAbleToRetrieveStateFromCurrentBoard() {
//        World newWorld = new World(io, 1, cellCalculatorStub, 500);
//
//        GridStub currentState = new GridStub(newWorld.io.getInitialState());
//        boolean[][] result = currentState.getLiveCells();
//        boolean[][] expected = {{false, true, false, false}, {true, true, true, false}, {false, false, false, true}, {true, false, true, false}};
//
//        assertArrayEquals(expected, result);
//    }
//
//    @Test
//    public void shouldCalculateNextStateFromCurrentState() {
//        World newWorld = new World(io, 1, cellCalculatorStub, 500);
//
//        GridStub currentState = new GridStub(newWorld.io.getInitialState());
//
//        boolean[][] newState = cellCalculatorStub.getNextTick(currentState.getLiveCells());
//        boolean[][] expected = {{false, false, false, false}, {true, true, true, true}, {false, false, false, false}, {true, true, true, true}};
//
//        currentState = new GridStub(newState);
//        boolean[][] result = currentState.getLiveCells();
//
//        assertArrayEquals(expected, result);
//    }
//
//    @Test
//    public void shouldSendStateToIOForDisplay() {
//        World newWorld = new World(io, 1, cellCalculatorStub, 500);
//        GridStub currentState = new GridStub(newWorld.io.getInitialState());
//        newWorld.io.display(currentState.getLiveCells());
//
//        boolean result = io.displayWasCalled;
//
//        assertTrue(result);
//    }
//
//    @Test
//    public void shouldSendAPredefinedNumberOfBoardsToTheIOThenEndGame() {
//        int numberOfTicks = 5;
//        World newWorld = new World(io, numberOfTicks, cellCalculatorStub, 10);
//
//        newWorld.run();
//
//        int result = io.displayCount;
//
//        assertEquals(5, result);
//    }
//
//    @Test
//    public void shouldTakeAPredefinedLengthBetweenTicksToPlayTheGame() {
//        int numberOfTicks = 1;
//        int sleepTime = 500;
//        World newWorld = new World(io, numberOfTicks, cellCalculatorStub, sleepTime);
//        long startTime = System.currentTimeMillis();
//        newWorld.run();
//        long endTime = System.currentTimeMillis();
//
//        assertTrue(endTime-startTime > 500);
//    }
//
//    @Test
//    public void shouldUpdateSentBoardWithEachTick() {
//        int numberOfTicks = 5;
//        int sleepTime = 500;
//        Calculator cellCalcualtor = new com.ness.CalculatorStarting();
//        World newWorld = new World(io, numberOfTicks, cellCalcualtor, sleepTime);
//
//
//    }
//}