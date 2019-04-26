package com.ness.conways;

import com.ness.conways.grid.*;
import com.ness.conways.output.IOutput;
import com.ness.conways.output.OutputMock;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class WorldTest {

    @Test
    public void shouldOutputGridAsManyTimesAsNumberOfTicks() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0), false));
        Grid2D initialState = new Grid2D(initialCellList, 1, 1);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        OutputMock output = new OutputMock();
        IGridCalculator calculator = new GridCalculatorStub();

        World game = new World(initialState, numberOfTicks, sleepTimeInMs, output, calculator);

        game.run();

        int result = output.printCount;

        assertEquals(5, result);
    }

    @Test
    public void shouldCalculateANewGridOnEachTick() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0), false));
        Grid2D initialState = new Grid2D(initialCellList, 1, 1);
        int numberOfTicks = 1;
        int sleepTimeInMs = 500;
        IOutput output = new OutputMock();
        GridCalculatorStub calculator = new GridCalculatorStub();

        World game = new World(initialState, numberOfTicks, sleepTimeInMs, output, calculator);

        game.run();

        boolean result = calculator.calculatorWasCalled;

        assertTrue(result);
    }

    @Test
    public void shouldWaitForLengthOfSleepTimeBetweenEachIteration() {
        ArrayList<Cell> initialCellList = new ArrayList<>();
        initialCellList.add(new Cell(new Location(0, 0), false));
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
    // TODO: Testing whole world by checking all the outputs rather than checking how long it has waited
}