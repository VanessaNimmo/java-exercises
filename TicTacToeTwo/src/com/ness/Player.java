package com.ness;

class Player {

    private final char marker;

    Player(char marker) {
        this.marker = marker;
    }

    char getMarker() {
        return marker;
    }

    public int choosePosition(int boardSize) {
        // Get an integer less than or equal to boardSize*boardSize
        return 4;
    }
}
