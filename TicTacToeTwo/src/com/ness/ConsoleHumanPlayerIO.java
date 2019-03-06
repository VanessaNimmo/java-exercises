package com.ness;

import java.util.Scanner;

public class ConsoleHumanPlayerIO implements IO {

    @Override
    public void print(String message) {
        System.out.format("%s%n", message);
    }

    @Override
    public int getNextMove(int rangeMin, int rangeMax, String board) {
        Scanner in = new Scanner(System.in);
        if(!in.hasNextInt()) {
            if (in.nextLine().equals("q")) return 0;
        }
        int nextMove = in.nextInt();
        while(!validateInputRange(rangeMin, rangeMax, nextMove)) {
            this.print("Please choose a valid square: ");
            nextMove = in.nextInt();
        }
        return nextMove;
    }

    private boolean validateInputRange(int rangeMin, int rangeMax, int moveToCheck) {
        return moveToCheck >= rangeMin && moveToCheck <= rangeMax;
    }
}
