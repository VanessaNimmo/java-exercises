package com.ness;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WorldTest {

    @Test
    public void shouldOutputGridAsManyTimesAsNumberOfTicks() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(1, 1, false));
        Grid2D initialState = new Grid2D(initialCellList, 1, 1);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        IOutput output = new OutputMock();
        IGridCalculator calculator = new GridCalculatorStub();

        World game = new World(initialState, numberOfTicks, sleepTimeInMs, output, calculator);

        game.run();

        int result = ((OutputMock) output).printCount;

        assertEquals(5, result);
    }

    @Test
    public void shouldCalculateANewGridOnEachTick() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(1, 1, false));
        Grid2D initialState = new Grid2D(initialCellList, 1, 1);
        int numberOfTicks = 1;
        int sleepTimeInMs = 500;
        IOutput output = new OutputMock();
        IGridCalculator calculator = new GridCalculatorStub();

        World game = new World(initialState, numberOfTicks, sleepTimeInMs, output, calculator);

        game.run();

        boolean result = ((GridCalculatorStub) calculator).calculatorWasCalled;

        assertTrue(result);
    }

    @Test
    public void shouldWaitForLengthOfSleepTimeBetweenEachIteration() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(1, 1, false));
        Grid2D initialState = new Grid2D(initialCellList, 1, 1);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        IOutput output = new OutputMock();
        IGridCalculator calculator = new GridCalculatorStub();

        World game = new World(initialState, numberOfTicks, sleepTimeInMs, output, calculator);
        long startTime = System.currentTimeMillis();
        game.run();
        long endTime = System.currentTimeMillis();
        long runningTime = endTime - startTime;

        assertTrue(runningTime > 2500);
    }
}