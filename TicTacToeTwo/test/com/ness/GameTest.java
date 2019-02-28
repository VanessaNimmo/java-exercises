package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void boardShouldBeEmptyAtStartOfGame () {
        int boardSize = 3;
        Board tictactoeBoard = new TicTacToeBoard(boardSize);
        String marker1 = "X", marker2 = "O";
        Player player1 = new RandomPlayer(marker1);
        Player player2 = new RandomPlayer(marker2);
        Game tictactoe = new Game(tictactoeBoard, player1, player2);

        String expected = "123\n456\n789\n";
        String result = tictactoe.board.toString();

        assertEquals(expected, result);
    }

    class TestBoard implements Board {

        @Override
        public int getSize() {
            return 0;
        }

        @Override
        public boolean isFull() {
            return true;
        }

        @Override
        public boolean squareIsAvailable(int markerPlacement) {
            return false;
        }

        @Override
        public void placeMarker(String marker, int markerPlacement) {

        }

        @Override
        public String markerHasWon() {
            return null;
        }
    }
}