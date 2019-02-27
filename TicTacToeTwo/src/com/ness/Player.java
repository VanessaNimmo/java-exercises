package com.ness;

interface Player {

    String marker = "X";

    String getMarker();

    int choosePosition(int boardSize);
}
