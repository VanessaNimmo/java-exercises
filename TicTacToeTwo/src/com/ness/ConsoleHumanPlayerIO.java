package com.ness;

import java.util.Scanner;

public class ConsoleHumanPlayerIO implements IO {

    @Override
    public void print(String message) {
        System.out.format("%s%n", message);
    }

    @Override
    public int getNextMove(int rangeMin, int rangeMax) {
        Scanner in = new Scanner(System.in);
        int nextMove = getUserInput(in);
        while (!validateInputRange(0, rangeMax, nextMove)) {
            this.print("Please choose a valid square or enter q to quit:");
            nextMove = getUserInput(in);
        }
        return nextMove;
    }

    private int getUserInput(Scanner in) {
        if(!in.hasNextInt()) {
            if (in.nextLine().equals("q")) return 0;
        }
        return in.nextInt();
    }

    private boolean validateInputRange(int rangeMin, int rangeMax, int moveToCheck) {
        return moveToCheck >= rangeMin && moveToCheck <= rangeMax;
    }
}
