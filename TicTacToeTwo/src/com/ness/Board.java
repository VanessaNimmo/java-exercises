package com.ness;

interface Board {

    int getSize();

    boolean isFull();

    boolean squareIsAvailable(int markerPlacement);

    void placeMarker(String marker, int markerPlacement);

    String markerHasWon();

}
