package com.ness;

class RandomPlayer implements Player {

    private final String name;
    private final Marker marker;

    RandomPlayer(Marker marker, String name) {
        this.marker = marker;
        this.name = name;
    }

    @Override
    public String getMarker() {
        return String.valueOf(marker);
    }

    @Override
    public String getName() { return name; }

    @Override
    public int choosePosition(int boardSize) {
        return (int) Math.floor(Math.random()*boardSize*boardSize + 1);
    }
}
