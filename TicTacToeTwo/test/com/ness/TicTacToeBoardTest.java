package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeBoardTest {

    @Test
    public void shouldReturnFalseWhenIsFullIsCalledOnAnEmptyBoard() {
        TicTacToeBoard board = new TicTacToeBoard(3);

        boolean result = board.isFull();

        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueWhenIsFullIsCalledOnAFullBoard() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        for(int i=0; i<board.getSize()*board.getSize(); i++) {
            board.placeMarker("X", i+1);
        }

        boolean result = board.isFull();

        assertTrue(result);
    }

    @Test
    public void squareIsAvailable() {
    }

    @Test
    public void placeMarker() {
    }

    @Test
    public void markerHasWon() {
    }
}