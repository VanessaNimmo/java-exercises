package com.ness.conways.grid;

import java.util.ArrayList;

public class GridStub implements IGrid {

    private final int aliveNeighbours;

    GridStub(int aliveNeighbours) {
        this.aliveNeighbours = aliveNeighbours;
    }

    @Override
    public int getNeighboursOfType(Location location, LifeType lifeType) {
        return this.aliveNeighbours;
    }

    @Override
    public int getGridWidth() {
        return 0;
    }

    @Override
    public int getGridHeight() {
        return 0;
    }

    @Override
    public ArrayList<Cell> getCellList() {

        return null;
    }
}
