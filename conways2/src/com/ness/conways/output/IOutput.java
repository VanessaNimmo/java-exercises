package com.ness.conways.output;

import com.ness.conways.grid.Cell;

import java.util.ArrayList;

public interface IOutput {

    void print(String message);

    void displayCellGrid(ArrayList<Cell> cellList, int gridWidth);
}
