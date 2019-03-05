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
            board.placeMarker(Marker.X, i+1);
        }

        boolean result = board.isFull();

        assertTrue(result);
    }

    @Test
    public void squareIsAvailableReturnsTrueWhenNoMarkerHasBeenPlacedThere() {
        TicTacToeBoard board = new TicTacToeBoard(3);

        boolean result = board.squareIsAvailable(1);

        assertTrue(result);
    }

    @Test
    public void squareIsAvailableReturnsFalseWhenAMarkerHasBeenPlacedThere() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.X, 9);

        boolean result = board.squareIsAvailable(9);

        assertFalse(result);
    }

    @Test
    public void shouldPlaceAMarkerAtArrayPosition0WhenMarkerPosition1IsEntered() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.X, 1);

        String result = board.toString();
        String expected = "X23\n456\n789\n";

        assertEquals(expected, result);
    }

    @Test
    public void shouldReturnFalseWhenMarkerHasWonIsCalledForAnEmptyBoard() {
        TicTacToeBoard board = new TicTacToeBoard(3);

        boolean result = board.markerHasWon();

        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenMarkerHasWonIsCalledForANoWinBoard() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.X, 1);
        board.placeMarker(Marker.X, 3);
        board.placeMarker(Marker.O, 2);

        boolean result = board.markerHasWon();

        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAnXWinBoardOfTopRow() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.X, 1);
        board.placeMarker(Marker.X, 2);
        board.placeMarker(Marker.X, 3);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAXWinBoardOfMiddleRow() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.X, 4);
        board.placeMarker(Marker.X, 5);
        board.placeMarker(Marker.X, 6);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAXWinBoardOfBottomRow() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.X, 7);
        board.placeMarker(Marker.X, 8);
        board.placeMarker(Marker.X, 9);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAXWinBoardOfFirstColumn() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.X, 1);
        board.placeMarker(Marker.X, 4);
        board.placeMarker(Marker.X, 7);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAXWinBoardOfSecondColumn() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.X, 2);
        board.placeMarker(Marker.X, 5);
        board.placeMarker(Marker.X, 8);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAXWinBoardOfThirdColumn() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.X, 3);
        board.placeMarker(Marker.X, 6);
        board.placeMarker(Marker.X, 9);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAXWinBoardOfLeftToRightDiagonal() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.X, 1);
        board.placeMarker(Marker.X, 5);
        board.placeMarker(Marker.X, 9);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAXWinBoardOfRightToLeftDiagonal() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.X, 3);
        board.placeMarker(Marker.X, 5);
        board.placeMarker(Marker.X, 7);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfTopRow() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.O, 1);
        board.placeMarker(Marker.O, 2);
        board.placeMarker(Marker.O, 3);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }


    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfMiddleRow() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.O, 4);
        board.placeMarker(Marker.O, 5);
        board.placeMarker(Marker.O, 6);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfBottomRow() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.O, 7);
        board.placeMarker(Marker.O, 8);
        board.placeMarker(Marker.O, 9);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfFirstColumn() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.O, 1);
        board.placeMarker(Marker.O, 4);
        board.placeMarker(Marker.O, 7);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfSecondColumn() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.O, 2);
        board.placeMarker(Marker.O, 5);
        board.placeMarker(Marker.O, 8);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfThirdColumn() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.O, 3);
        board.placeMarker(Marker.O, 6);
        board.placeMarker(Marker.O, 9);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfLeftToRightDiagonal() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.O, 1);
        board.placeMarker(Marker.O, 5);
        board.placeMarker(Marker.O, 9);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfRightToLeftDiagonal() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker(Marker.O, 3);
        board.placeMarker(Marker.O, 5);
        board.placeMarker(Marker.O, 7);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForASize4BoardOfRightToLeftDiagonal() {
        TicTacToeBoard board = new TicTacToeBoard(4);
        board.placeMarker(Marker.X, 4);
        board.placeMarker(Marker.X, 7);
        board.placeMarker(Marker.X, 10);
        board.placeMarker(Marker.X, 13);

        boolean result = board.markerHasWon();

        assertTrue(result);
    }

}