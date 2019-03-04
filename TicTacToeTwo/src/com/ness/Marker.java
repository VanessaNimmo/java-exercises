package com.ness;

public enum Marker {

    X("X"), Y("Y"), E("*");

    private String stringRepresentation;

    private Marker(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
