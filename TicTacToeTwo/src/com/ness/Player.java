package com.ness;

class Player {

    private final String name;
    private final Marker marker;

   Player(Marker marker, String name) {
        this.marker = marker;
        this.name = name;
    }

    public Marker getMarker() { return marker; }

    public String getName() { return name; }
}
