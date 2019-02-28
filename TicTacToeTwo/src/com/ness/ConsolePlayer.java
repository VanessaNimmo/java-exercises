package com.ness;

public class ConsolePlayer implements Player {

    private final String marker;

    ConsolePlayer(String marker) {
        this.marker = marker;
    }

    @Override
    public String getMarker() {
        return this.marker;
    }

    @Override
    public int choosePosition(int boardSize) {
        return 0;
    }
}
