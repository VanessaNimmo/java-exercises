package com.ness;

import java.util.ArrayList;

interface IOutput {

    void print(String message);

    void displayCellGrid(ArrayList<Cell> cellList, int gridWidth);
}
