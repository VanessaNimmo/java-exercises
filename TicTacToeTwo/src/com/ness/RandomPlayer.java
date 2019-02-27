package com.ness;

class RandomPlayer implements Player {

    private final String marker;

    RandomPlayer(String marker) {
        this.marker = marker;
    }

    public String getMarker() {
        return marker;
    }

    public int choosePosition(int boardSize) {
        // Get an integer less than or equal to boardSize*boardSize
        return (int) Math.floor(Math.random()*boardSize*boardSize + 1);

        // Test mock returns exactly 4
//        return 4;
    }
}
