package com.ness;

interface Board {

    int size = 0;

    int getSize();

    boolean isFull();

    String toString();

    boolean squareIsAvailable(int markerPlacement);

    void placeMarker(char marker, int markerPlacement);

}
