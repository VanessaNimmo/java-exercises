package com.ness;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ConwaysTest {

    @Test
    public void shouldBeInitialisedWithAStartingGridAndNumOfTicksAndSleepTimeAndOutput() {
        boolean[][] startingCells = {{false}};
        Grid2D initialState = new Grid2D(startingCells);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        Output output = new OutputStub();
        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output);

        assertNotNull(game);
    }

    @Test
    public void shouldRunDisplayGridAsManyTimesAsNumberOfTicks() {
        boolean[][] startingCells = {{false}};
        Grid2D initialState = new Grid2D(startingCells);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        Output output = new OutputStub();
        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output);

        game.run();

        int result = ((OutputStub) output).printCount;

        assertEquals(5, result);
    }

    @Test
    public void shouldBeInitialisedWithACalculator() {
        boolean[][] startingCells = {{false}};
        Grid2D initialState = new Grid2D(startingCells);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        Output output = new OutputStub();
        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output);

        assertNotNull(game);
    }

    @Test
    public void shouldCalculateANewGridOnEachTickAndStoreItInHistory() {
        boolean[][] startingCells = {{false}};
        Grid2D initialState = new Grid2D(startingCells);
        int numberOfTicks = 1;
        int sleepTimeInMs = 500;
        Output output = new OutputStub();
        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output);

        game.run();

        ArrayList<Grid2D> result = game.getHistory();

        assertTrue(result.size()==2);
    }

    @Test
    public void shouldWaitForLengthOfSleepTimeBetweenEachIteration() {
        boolean[][] startingCells = {{false}};
        Grid2D initialState = new Grid2D(startingCells);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        Output output = new OutputStub();
        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output);
        long startTime = System.currentTimeMillis();
        game.run();
        long endTime = System.currentTimeMillis();
        long runningTime = endTime - startTime;

        assertTrue(runningTime > 2500);
    }
}