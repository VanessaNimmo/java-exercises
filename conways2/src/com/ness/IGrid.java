package com.ness;

import java.util.ArrayList;

public interface Grid {

    int getAliveNeighbours(int row, int column);

    int getGridWidth();

    int getGridHeight();

    ArrayList<Cell> getCellList();
}
