package com.ness.conways.grid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Grid2D implements IGrid {

    private final ArrayList<Cell> cellList;
    private final int gridHeight, gridWidth;

    public Grid2D(ArrayList<Cell> cellList, int gridHeight, int gridWidth) {
        this.gridHeight = gridHeight;
        this.gridWidth = gridWidth;
        this.cellList = cellList;
    }

    @Override
    public int getGridHeight() { return this.gridHeight; }

    @Override
    public int getGridWidth() { return this.gridWidth; }

    @Override
    public ArrayList<Cell> getCellList() { return this.cellList; }

    @Override
    public int getNeighboursOfType(Location location, LifeType lifeType) {
        return calculateNeighboursOfType(location.getRow(), location.getColumn(), lifeType);
    }

    private int calculateNeighboursOfType(int row, int column, LifeType lifeType) {
        int rowAbove = getPreviousRowOrColumn(row, this.gridHeight);
        int rowBelow = getNextRowOrColumn(row, this.gridHeight);
        int columnBefore = getPreviousRowOrColumn(column, this.gridWidth);
        int columnAfter = getNextRowOrColumn(column, this.gridWidth);
        List<Cell> cells = getNeighbouringCellsList(rowAbove, row, rowBelow, columnBefore, column, columnAfter);
        return (int) cells.stream().filter(cell -> cell.getLifeType()==lifeType).count();
    }

    private List<Cell> getNeighbouringCellsList(int rowAbove, int row, int rowBelow, int columnBefore, int column, int columnAfter) {
        List<Cell> neighbouringCells = new ArrayList<>();
        neighbouringCells.add(findCell(rowAbove, columnBefore));
        neighbouringCells.add(findCell(rowAbove, column));
        neighbouringCells.add(findCell(rowAbove, columnAfter));
        neighbouringCells.add(findCell(row, columnBefore));
        neighbouringCells.add(findCell(row, columnAfter));
        neighbouringCells.add(findCell(rowBelow, columnBefore));
        neighbouringCells.add(findCell(rowBelow, column));
        neighbouringCells.add(findCell(rowBelow, columnAfter));
        return neighbouringCells;
    }

    private Cell findCell(int row, int column) {
        return this.cellList.stream().filter(cell -> cell.getLocation().getRow() == row && cell.getLocation().getColumn()==column).collect(Collectors.toCollection(ArrayList::new)).get(0);
    }

    private int getNextRowOrColumn(int rowOrColumn, int lengthOfRowOrColumn) {
        return rowOrColumn + 1 == lengthOfRowOrColumn ? 0 : rowOrColumn + 1;
    }

    private int getPreviousRowOrColumn(int rowOrColumn, int lengthOfRowOrColumn) {
        return rowOrColumn - 1 < 0 ? lengthOfRowOrColumn - 1 : rowOrColumn - 1;
    }
}