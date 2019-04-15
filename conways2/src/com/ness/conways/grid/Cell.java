package com.ness.conways.grid;

public class Cell {

    private Location location;
    private boolean alive;

    public Cell(Location location, boolean alive){
        this.location = location;
        this.alive = alive;
    }

    Location getLocation() { return this.location; }
    public boolean getAlive() { return this.alive; }
}
