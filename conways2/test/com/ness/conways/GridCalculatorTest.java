package com.ness.conways;

import com.ness.conways.grid.GridCalculator;
import com.ness.conways.grid.IGrid;
import org.junit.Test;

public class GridCalculatorTest {

    @Test
    public void aLiveCellWithThreeLiveNeighboursShouldBeAliveInNextTick() {
        GridCalculator calculator = new GridCalculator();
        IGrid initialState = new GridStub(3);

        calculator.getNextTick(initialState);


    }

    @Test
    public void aLiveCellWithTwoLiveNeighboursShouldBeAliveInNextTick() {

    }

    @Test
    public void aDeadCellWithThreeLiveNeighboursShouldBeAliveInNextTick() {

    }

    @Test
    public void aLiveCellWithOneLiveNeighbourShouldBeDeadInNextTick() {

    }

    @Test
    public void aLiveCellWithFourOrMoreLiveNeighboursShouldBeDeadInNextTick() {

    }

    @Test
    public void aDeadCellWithTwoOrFewerLiveNeighboursShouldRemainDeadInNextTick() {

    }

    @Test
    public void aDeadCellWithFourOrMoreLiveNeighboursShouldRemainDeadInNextTick() {

    }


}