package com.ness;

public interface Grid {

    boolean cellIsAlive(int row, int column);

    int aliveNeighbours(int row, int column);
}
