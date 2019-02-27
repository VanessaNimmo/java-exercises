package com.ness;

class Player {

    private final String marker;

    Player(String marker) {
        this.marker = marker;
    }

    String getMarker() {
        return marker;
    }

    int choosePosition(int boardSize) {
        // Get an integer less than or equal to boardSize*boardSize
        return (int) Math.floor(Math.random()*boardSize*boardSize + 1);

        // Test mock returns exactly 4
//        return 4;
    }
}
