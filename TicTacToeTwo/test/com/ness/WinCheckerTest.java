package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class WinCheckerTest {

    @Test
    public void shouldReturnFalseWhenMarkerHasWonIsCalledForAnEmptyBoard() {
        WinChecker checker = new WinChecker();
        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        boolean result = board.gameIsWon();

        assertFalse(result);
    }

    @Test
    public void shouldReturnFalseWhenMarkerHasWonIsCalledForANoWinBoard() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.X, 1);
        board.placeMarker(Marker.X, 3);
        board.placeMarker(Marker.O, 2);

        boolean result = board.gameIsWon();

        assertFalse(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAnXWinBoardOfTopRow() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.X, 1);
        board.placeMarker(Marker.X, 2);
        board.placeMarker(Marker.X, 3);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAXWinBoardOfMiddleRow() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.X, 4);
        board.placeMarker(Marker.X, 5);
        board.placeMarker(Marker.X, 6);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAXWinBoardOfBottomRow() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.X, 7);
        board.placeMarker(Marker.X, 8);
        board.placeMarker(Marker.X, 9);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAXWinBoardOfFirstColumn() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.X, 1);
        board.placeMarker(Marker.X, 4);
        board.placeMarker(Marker.X, 7);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAXWinBoardOfSecondColumn() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.X, 2);
        board.placeMarker(Marker.X, 5);
        board.placeMarker(Marker.X, 8);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAXWinBoardOfThirdColumn() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.X, 3);
        board.placeMarker(Marker.X, 6);
        board.placeMarker(Marker.X, 9);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAXWinBoardOfLeftToRightDiagonal() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.X, 1);
        board.placeMarker(Marker.X, 5);
        board.placeMarker(Marker.X, 9);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAXWinBoardOfRightToLeftDiagonal() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.X, 3);
        board.placeMarker(Marker.X, 5);
        board.placeMarker(Marker.X, 7);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfTopRow() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.O, 1);
        board.placeMarker(Marker.O, 2);
        board.placeMarker(Marker.O, 3);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }


    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfMiddleRow() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.O, 4);
        board.placeMarker(Marker.O, 5);
        board.placeMarker(Marker.O, 6);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfBottomRow() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.O, 7);
        board.placeMarker(Marker.O, 8);
        board.placeMarker(Marker.O, 9);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfFirstColumn() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.O, 1);
        board.placeMarker(Marker.O, 4);
        board.placeMarker(Marker.O, 7);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfSecondColumn() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.O, 2);
        board.placeMarker(Marker.O, 5);
        board.placeMarker(Marker.O, 8);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfThirdColumn() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.O, 3);
        board.placeMarker(Marker.O, 6);
        board.placeMarker(Marker.O, 9);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfLeftToRightDiagonal() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.O, 1);
        board.placeMarker(Marker.O, 5);
        board.placeMarker(Marker.O, 9);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForAOWinBoardOfRightToLeftDiagonal() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(3, checker);

        board.placeMarker(Marker.O, 3);
        board.placeMarker(Marker.O, 5);
        board.placeMarker(Marker.O, 7);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

    @Test
    public void shouldReturnTrueWhenMarkerHasWonIsCalledForASize4BoardOfRightToLeftDiagonal() {
        WinChecker checker = new WinChecker();

        TicTacToeBoard board = new TicTacToeBoard(4, checker);

        board.placeMarker(Marker.X, 4);
        board.placeMarker(Marker.X, 7);
        board.placeMarker(Marker.X, 10);
        board.placeMarker(Marker.X, 13);

        boolean result = board.gameIsWon();

        assertTrue(result);
    }

}