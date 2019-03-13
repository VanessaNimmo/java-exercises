package com.ness;

import java.util.Scanner;

public class ConsoleIO implements InputOutput {

    @Override
    public boolean[][] getInitialState() {
        boolean[][] emptyGrid = getNewGrid();
        boolean[][] initialState = addLiveStartingCells(emptyGrid);
        return initialState;
    }

    @Override
    public void display(boolean[][] liveCells) {
        System.out.format("%n");
        String cell;
        int gridHeight = liveCells.length;
        int gridWidth = liveCells[0].length;
        for (int row = 0; row < gridHeight; row++ ) {
            for( int column = 0; column < gridWidth; column++) {
                cell = liveCells[row][column]==true ? "\uD83C\uDF06" : "\uD83C\uDFD9";
                System.out.print(cell);
            }
            System.out.format("%n");
        }
    }

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    boolean[][] getNewGrid() {
        System.out.print("Please enter the height and width of the world grid, separated by a space:");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int[] gridSize = parseIntegerPair(input);
        while (gridSize[0] > 56 || gridSize[1] > 56) {
            System.out.print("Please choose a grid size smaller than 56");
            input = in.nextLine();
            gridSize = parseIntegerPair(input);
        }
        return new boolean[gridSize[0]][gridSize[1]];
    }

    private boolean[][] addLiveStartingCells(boolean[][] startingGrid) {
        startingGrid = addLiveCell(startingGrid);
        System.out.print("Add another cell? y/n");
        Scanner in = new Scanner(System.in);
        if(in.nextLine().equals("y")) {

        }
        return startingGrid;
    }

    boolean[][] addLiveCell(boolean[][] startingGrid) {
        System.out.print("Enter the location of the live starting cell, counting across then down. Separate the numbers with a space: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int[] cellLocation = parseIntegerPair(input);
        if (cellLocation[1] > startingGrid.length || cellLocation[0] > startingGrid[0].length) {
            System.out.print("Invalid placement. Please choose inside the grid.");
        } else {
            startingGrid[cellLocation[1]-1][cellLocation[0]-1] = true;
        }
        return startingGrid;
    }

    private int[] parseIntegerPair(String expression) {
        String[] splitInput = expression.split(" ");
        int[] integerPair = new int[2];
        for (int i=0; i < 2; i++) {
            integerPair[i] = Integer.parseInt(splitInput[i]);
        }
        return integerPair;
    }
}
