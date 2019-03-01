package com.ness;

public class ConsolePlayer implements Player {

    private final String marker, name;

    ConsolePlayer(String marker, String name) {
        this.marker = marker;
        this.name = name;
    }

    @Override
    public String getMarker() {
        return this.marker;
    }

    @Override
    public String getName() { return this.name; }

    @Override
    public int choosePosition(int boardSize) {
        return 0;
    }
}
