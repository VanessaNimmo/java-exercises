package com.ness;

interface Player {

    Marker getMarker();

    String getName();

    int choosePosition(int boardSize);
}
