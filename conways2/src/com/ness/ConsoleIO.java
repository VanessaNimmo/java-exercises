package com.ness;

import java.util.Scanner;

public class ConsoleIO implements InputOutput {

    @Override
    public boolean[][] getInitialState() {
        int[] gridSize = getGridSize();
        boolean[][] initialState = new boolean[gridSize[0]][gridSize[1]];
        return initialState;
    }

    @Override
    public void display(boolean[][] liveCells) {

        System.out.print("\n");
        String cell;
        int gridHeight = liveCells.length;
        int gridWidth = liveCells[0].length;
        for (int row = 0; row < gridHeight; row++ ) {
            for( int column = 0; column < gridWidth; column++) {
                cell = liveCells[row][column] ? "\uD83C\uDF06" : "\uD83C\uDFD9";
                System.out.print(cell);
            }
            System.out.print("\n");
        }

    }

    @Override
    public void print(String message) {
        System.out.print(message);
    }

    int[] getGridSize() {
        System.out.print("Please enter the height and width of the world grid, separated by a space:");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] splitInput = input.split(" ");
        int[] gridSize = new int[2];
        for (int i=0; i < 2; i++) {
            gridSize[i] = Integer.parseInt(splitInput[i]);
        }
        return gridSize;
    }

    boolean[][] addLiveCell(boolean[][] emptyGrid) {
        return new boolean[0][0];
    }
}
