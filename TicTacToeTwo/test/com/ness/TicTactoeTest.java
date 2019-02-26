package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class TicTactoeTest {

    @Test
    public void shouldReturnNWhenMarkerHasWonIsCalledForANoWinBoard() {
        TicTacToeBoard board = new TicTacToeBoard(3);

        String result = board.markerHasWon();

        assertEquals("N", result);
    }

    @Test
    public void shouldReturnXWhenMarkerHasWonIsCalledForAXWinBoardOfTopRow() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("X", 1);
        board.placeMarker("X", 2);
        board.placeMarker("X", 3);

        String result = board.markerHasWon();

        assertEquals("X", result);
    }

    @Test
    public void shouldReturnXWhenMarkerHasWonIsCalledForAXWinBoardOfMiddleRow() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("X", 4);
        board.placeMarker("X", 5);
        board.placeMarker("X", 6);

        String result = board.markerHasWon();

        assertEquals("X", result);
    }

    @Test
    public void shouldReturnXWhenMarkerHasWonIsCalledForAXWinBoardOfBottomRow() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("X", 7);
        board.placeMarker("X", 8);
        board.placeMarker("X", 9);

        String result = board.markerHasWon();

        assertEquals("X", result);
    }

    @Test
    public void shouldReturnXWhenMarkerHasWonIsCalledForAXWinBoardOfFirstColumn() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("X", 1);
        board.placeMarker("X", 4);
        board.placeMarker("X", 7);

        String result = board.markerHasWon();

        assertEquals("X", result);
    }

    @Test
    public void shouldReturnXWhenMarkerHasWonIsCalledForAXWinBoardOfSecondColumn() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("X", 2);
        board.placeMarker("X", 5);
        board.placeMarker("X", 8);

        String result = board.markerHasWon();

        assertEquals("X", result);
    }

    @Test
    public void shouldReturnXWhenMarkerHasWonIsCalledForAXWinBoardOfThirdColumn() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("X", 3);
        board.placeMarker("X", 6);
        board.placeMarker("X", 9);

        String result = board.markerHasWon();

        assertEquals("X", result);
    }

    @Test
    public void shouldReturnXWhenMarkerHasWonIsCalledForAXWinBoardOfFirstDiagonal() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("X", 1);
        board.placeMarker("X", 5);
        board.placeMarker("X", 9);

        String result = board.markerHasWon();

        assertEquals("X", result);
    }

    @Test
    public void shouldReturnXWhenMarkerHasWonIsCalledForAXWinBoardOfSecondDiagonal() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("X", 3);
        board.placeMarker("X", 5);
        board.placeMarker("X", 7);

        String result = board.markerHasWon();

        assertEquals("X", result);
    }

    @Test
    public void shouldReturnOWhenMarkerHasWonIsCalledForAOWinBoardOfTopRow() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("O", 1);
        board.placeMarker("O", 2);
        board.placeMarker("O", 3);

        String result = board.markerHasWon();

        assertEquals("O", result);
    }


    @Test
    public void shouldReturnOWhenMarkerHasWonIsCalledForAOWinBoardOfMiddleRow() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("O", 4);
        board.placeMarker("O", 5);
        board.placeMarker("O", 6);

        String result = board.markerHasWon();

        assertEquals("O", result);
    }

    @Test
    public void shouldReturnOWhenMarkerHasWonIsCalledForAOWinBoardOfBottomRow() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("O", 7);
        board.placeMarker("O", 8);
        board.placeMarker("O", 9);

        String result = board.markerHasWon();

        assertEquals("O", result);
    }

    @Test
    public void shouldReturnOWhenMarkerHasWonIsCalledForAOWinBoardOfFirstColumn() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("O", 1);
        board.placeMarker("O", 4);
        board.placeMarker("O", 7);

        String result = board.markerHasWon();

        assertEquals("O", result);
    }

    @Test
    public void shouldReturnOWhenMarkerHasWonIsCalledForAOWinBoardOfSecondColumn() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("O", 2);
        board.placeMarker("O", 5);
        board.placeMarker("O", 8);

        String result = board.markerHasWon();

        assertEquals("O", result);
    }

    @Test
    public void shouldReturnOWhenMarkerHasWonIsCalledForAOWinBoardOfThirdColumn() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("O", 3);
        board.placeMarker("O", 6);
        board.placeMarker("O", 9);

        String result = board.markerHasWon();

        assertEquals("O", result);
    }

    @Test
    public void shouldReturnOWhenMarkerHasWonIsCalledForAOWinBoardOfFirstDiagonal() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("O", 1);
        board.placeMarker("O", 5);
        board.placeMarker("O", 9);

        String result = board.markerHasWon();

        assertEquals("O", result);
    }

    @Test
    public void shouldReturnOWhenMarkerHasWonIsCalledForAOWinBoardOfSecondDiagonal() {
        TicTacToeBoard board = new TicTacToeBoard(3);
        board.placeMarker("O", 3);
        board.placeMarker("O", 5);
        board.placeMarker("O", 7);

        String result = board.markerHasWon();

        assertEquals("O", result);
    }
}