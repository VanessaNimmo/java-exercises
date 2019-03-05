package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void boardShouldBeEmptyAtStartOfGame() {
        int boardSize = 3;
        Board tictactoeBoard = new TicTacToeBoard(boardSize);
        Marker marker1 = Marker.X, marker2 = Marker.O;
        Player player1 = new RandomPlayer(marker1, "Player 1");
        Player player2 = new RandomPlayer(marker2, "Player 2");
        IO inputOutput = new ConsoleIO();
        Game tictactoe = new Game(tictactoeBoard, player1, player2, inputOutput);

        String expected = "123\n456\n789\n";
        String result = tictactoe.board.toString();

        assertEquals(expected, result);
    }

    @Test
    public void boardShouldEndGameWithDrawConditionIfBoardIsFull() {
        int boardSize = 3;
        Board tictactoe = new TestBoard(boardSize);

        // Does there need to be some sort of win flag or draw flag? There sort of is but its not really doing the job well
    }

    class TestBoard implements Board {

        private final int size;

        TestBoard(int boardSize) {
            this.size = boardSize;
        }
        @Override
        public int getSize() {
            return this.size;
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
        public void placeMarker(Marker marker, int markerPlacement) {

        }

        @Override
        public boolean markerHasWon() {
            return false;
        }
    }
}