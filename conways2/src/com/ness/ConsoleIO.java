package com.ness;

import java.util.Scanner;

public class ConsoleIO implements InputOutput {

    @Override
    public String getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    @Override
    public void display(Grid worldState) {
        System.out.print(worldState.toString());
    }

    @Override
    public void print(String message) {
        System.out.print(message);
    }
}