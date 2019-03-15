package com.ness;

public enum Message {

    WELCOME("Welcome to Conway's Game of Life!\n"),
    GRID("Please enter the height and width of the world grid, separated by a space:\n"),
    GRID_SIZE_ERROR("Please enter a grid size smaller than 56\n"),
    ENTER_ANOTHER_CELL("Add another cell? y/n\n"),
    CELL("Enter the location of the live starting cell, counting across then down. Separate the numbers with a space:\n"),
    INVALID_PLACEMENT("Invalid placement. Please choose inside the grid."),
    INPUT_RULES( "Please enter digits only, separated by a single space:");

    private final String content;

    Message(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
