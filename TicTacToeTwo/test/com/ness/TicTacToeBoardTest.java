package com.ness;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacToeBoardTest {

    private WinChecker checker;

    @Before
    public void setUp() {
       this.checker = new WinChecker();
    }

    @Test
    public void shouldBeEmptyWhenInitialised() {
        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        String result = board.toString();
        String expected = "123\n456\n789\n";

        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnFalseWhenIsFullIsCalledOnAnEmptyBoard() {
        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        boolean result = board.isFull();

        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueWhenIsFullIsCalledOnAFullBoard() {
        TicTacToeBoard board = new TicTacToeBoard(3, checker);
        for(int i=0; i<board.getSize()*board.getSize(); i++) {
            board.placeMarker(Marker.X, i+1);
        }

        boolean result = board.isFull();

        assertTrue(result);
    }

    @Test
    public void squareIsAvailableReturnsTrueWhenNoMarkerHasBeenPlacedThere() {
        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        boolean result = board.squareIsAvailable(1);

        assertTrue(result);
    }

    @Test
    public void squareIsAvailableReturnsFalseWhenAMarkerHasBeenPlacedThere() {
        TicTacToeBoard board = new TicTacToeBoard(3, checker);
        board.placeMarker(Marker.X, 9);

        boolean result = board.squareIsAvailable(9);

        assertFalse(result);
    }

    @Test
    public void shouldPlaceAMarkerAtPosition1WhenPosition1IsEntered() {
        TicTacToeBoard board = new TicTacToeBoard(3, checker);
        board.placeMarker(Marker.X, 1);

        String result = board.toString();
        String expected = "X23\n456\n789\n";

        assertEquals(expected, result);
    }
}