package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void shouldBeSize3By3WhenPassed3AtInitialise() {
        Board tictactoe = new Board(3);

        int result = tictactoe.size;

        assertEquals(3, result);
    }

    @Test
    public void shouldReturnTrueWhenMoveIsValid() {
        Board tictactoe = new Board(3);
        int entry = 1;
        int xCoord = 0;
        int yCoord = 0;

        boolean result = tictactoe.moveIsValid(entry, xCoord, yCoord);

        assertEquals(true, result);
    }

    @Test
    public void shouldReturnFalseWhenMoveIsOffTheBoard() {
        Board tictactoe = new Board(3);
        int entry = 1;
        int xCoord = 3;
        int yCoord = 1;

        boolean result = tictactoe.moveIsValid(entry, xCoord, yCoord);

        assertEquals(false, result);
    }

}