package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConwaysTest {

    @Test
    public void shouldBeInitialisedWithAStartingGridAndNumOfTicksAndSleepTimeAndOutput() {
        boolean[][] startingCells = {{false}};
        Grid initialState = new Grid(startingCells);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        Output output = new OutputStub();
        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output);

        assertNotNull(game);
    }

    @Test
    public void runShouldPrintAsManyTimesAsNumberOfTicks() {
        boolean[][] startingCells = {{false}};
        Grid initialState = new Grid(startingCells);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        Output output = new OutputStub();
        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs, output);

        game.run();

        int result = ((OutputStub) output).printCount;

        assertEquals(5, result);

    }

}