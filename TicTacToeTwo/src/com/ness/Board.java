package com.ness;

interface Board {

    int getSize();

    boolean isFull();

    boolean squareIsAvailable(int markerPlacement);

    void placeMarker(Marker marker, int markerPlacement);

    boolean markerHasWon();

}
