package com.ness;

import java.util.ArrayList;

interface Output {

    void print(String message);

    void displayCellGrid(ArrayList<Cell> cellList, int gridWidth);
}
