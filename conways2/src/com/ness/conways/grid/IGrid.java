package com.ness.conways.grid;

import java.util.ArrayList;

public interface IGrid {

    int getAliveNeighbours(Location location);

    int getGridWidth();

    int getGridHeight();

    ArrayList<Cell> getCellList();
}
