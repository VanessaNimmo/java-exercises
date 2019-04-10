package com.ness;

public class Cell {

    private Location location;
    private boolean alive;

    Cell(Location location, boolean alive){
        this.location = location;
        this.alive = alive;
    }

    Location getLocation() { return this.location; }
    boolean getAlive() { return this.alive; }
}
