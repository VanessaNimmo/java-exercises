package com.ness;

public class ConsolePlayer implements Player {

    private final String name;
    private final Marker marker;

    ConsolePlayer(Marker marker, String name) {
        this.marker = marker;
        this.name = name;
    }

    @Override
    public Marker getMarker() {
        return this.marker;
    }

    @Override
    public String getName() { return this.name; }

    @Override
    public int choosePosition(int boardSize) {
        return 0;
    }
}
