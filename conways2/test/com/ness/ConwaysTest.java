package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConwaysTest {

    @Test
    public void shouldBeInitialisedWithAStartingGridAndNumOfTicksAndSleepTime() {
        boolean[][] startingCells = {{false}};
        Grid initialState = new Grid(startingCells);
        int numberOfTicks = 5;
        int sleepTimeInMs = 500;
        Conways game = new Conways(initialState, numberOfTicks, sleepTimeInMs);

        assertNotNull(game);
    }

}