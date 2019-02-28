package com.ness;

class RandomPlayer implements Player {

    private final String marker;

    RandomPlayer(String marker) {
        this.marker = marker;
    }

    @Override
    public String getMarker() {
        return marker;
    }

    @Override
    public int choosePosition(int boardSize) {
        return (int) Math.floor(Math.random()*boardSize*boardSize + 1);
    }
}
