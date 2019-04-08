package com.ness;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ConwaysTest {

    @Test
    public void shouldOutputGridAsManyTimesAsNumberOfTicks() {
        boolean[][] startingCells = {{false}};
        Grid2D initialState = new Grid2D(startingCells);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        Output output = new OutputMock();
        GridCalculator calculator = new GridCalculatorStub();

        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output, calculator);

        game.run();

        int result = ((OutputMock) output).printCount;

        assertEquals(5, result);
    }

    // TODO Needs a test to check that it is calculating a new grid, and THEN a test to check that it goes into history - could check if it is calling a calculator, or could check a canned response from the grid calculator. This test would keep passing even if the app was broken
    @Test
    public void shouldCalculateANewGridOnEachTickAndStoreItInHistory() {
        boolean[][] startingCells = {{false}};
        Grid2D initialState = new Grid2D(startingCells);
        int numberOfTicks = 1;
        int sleepTimeInMs = 500;
        Output output = new OutputMock();
        GridCalculator calculator = new GridCalculatorStub();

        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output, calculator);

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
        Output output = new OutputMock();
        GridCalculator calculator = new GridCalculatorStub();

        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output, calculator);
        long startTime = System.currentTimeMillis();
        game.run();
        long endTime = System.currentTimeMillis();
        long runningTime = endTime - startTime;

        assertTrue(runningTime > 2500);
    }
}