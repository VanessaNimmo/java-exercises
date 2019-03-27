package com.ness;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ConwaysTest {

    @Test
    public void shouldBeInitialisedWithAStartingGridAndNumOfTicksAndSleepTimeAndOutput() {
        boolean[][] startingCells = {{false}};
        Grid initialState = new Grid(startingCells);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        Output output = new OutputStub();
        Calculator tickCalculator = new TickCalculator();
        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output, tickCalculator);

        assertNotNull(game);
    }

    @Test
    public void runShouldPrintAsManyTimesAsNumberOfTicks() {
        boolean[][] startingCells = {{false}};
        Grid initialState = new Grid(startingCells);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        Output output = new OutputStub();
        Calculator tickCalculator = new TickCalculator();
        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output, tickCalculator);

        game.run();

        int result = ((OutputStub) output).printCount;

        assertEquals(5, result);
    }

    @Test
    public void shouldBeInitialisedWithACalculator() {
        boolean[][] startingCells = {{false}};
        Grid initialState = new Grid(startingCells);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        Output output = new OutputStub();
        Calculator tickCalculator = new TickCalculator();
        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output, tickCalculator);

        assertNotNull(game);
    }

    @Test
    public void shouldCalculateANewGridOnEachTickAndStoreItInHistory() {
        boolean[][] startingCells = {{false}};
        Grid initialState = new Grid(startingCells);
        int numberOfTicks = 1;
        int sleepTimeInMs = 500;
        Output output = new OutputStub();
        Calculator tickCalculator = new TickCalculator();
        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output, tickCalculator);

        game.run();

        ArrayList<Grid> result = game.getHistory();
        ArrayList<Grid> expected = new ArrayList<>();
        expected.add(initialState);
        expected.add(tickCalculator.getNextTick(initialState));

        assertEquals(String.valueOf(expected.get(0)), String.valueOf(result.get(0)));
        assertEquals(String.valueOf(expected.get(1)), String.valueOf(result.get(1)));
    }

    @Test
    public void shouldWaitForLengthOfSleepTimeBetweenEachIteration() {
        boolean[][] startingCells = {{false}};
        Grid initialState = new Grid(startingCells);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        Output output = new OutputStub();
        Calculator tickCalculator = new TickCalculator();
        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output, tickCalculator);
        long startTime = System.currentTimeMillis();
        game.run();
        long endTime = System.currentTimeMillis();
        long runningTime = endTime - startTime;

        assertTrue(runningTime > 2500);
    }
}