package com.ness.conways.grid;

public class Cell {

    private Location location;
    private LifeType lifeType;

    public Cell(Location location, LifeType lifeType){
        this.location = location;
        this.lifeType = lifeType;
    }

    public Location getLocation() { return this.location; }
    public LifeType getLifeType() { return this.lifeType; }
}
