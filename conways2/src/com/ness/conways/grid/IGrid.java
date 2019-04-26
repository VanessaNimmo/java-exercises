package com.ness.conways.grid;

import java.util.ArrayList;

public interface IGrid {

    int getNeighboursOfType(Location location, LifeType lifeType);

    int getGridWidth();

    int getGridHeight();

    ArrayList<Cell> getCellList();
}
