package com.ness;

public enum Marker {

    X("X"), O("O"), E("*");

    private String stringRepresentation;

    Marker(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
