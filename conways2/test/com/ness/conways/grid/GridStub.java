package com.ness.conways;

import com.ness.conways.grid.IGrid;
import com.ness.conways.grid.Location;
import com.ness.conways.grid.Cell;

import java.util.ArrayList;

public class GridStub implements IGrid {

    private final int aliveNeighbours;

    GridStub(int aliveNeighbours) {
        this.aliveNeighbours = aliveNeighbours;
    }

    @Override
    public int getAliveNeighbours(Location location) {
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
