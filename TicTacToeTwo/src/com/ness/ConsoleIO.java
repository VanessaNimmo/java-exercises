package com.ness;

public class ConsoleIO implements IO {

    @Override
    public void printWelcomeMessage(String gameName) {
        System.out.format("Welcome to %s!", gameName);
    }

    @Override
    public int getBoard() {
        return 0;
    }
}
