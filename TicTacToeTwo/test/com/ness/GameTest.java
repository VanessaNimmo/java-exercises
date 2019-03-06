package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void gameShouldEndGameWithDrawConditionIfBoardIsFull() {
        int boardSize = 3;
        WinChecker checker = new WinChecker();
        FullTestBoard fullBoard = new FullTestBoard(boardSize, checker);
        DrawIO drawIO = new DrawIO();
        Game testGame = new Game(fullBoard, new Player(Marker.X, "Player 1"), new Player(Marker.O, "Player 2"), drawIO, drawIO);

        testGame.play();

        boolean result = drawIO.printWasCalledWithDrawMessage;

        assertTrue(result);

    }

    @Test
    public void whenUserQuitsGameShouldNotAskBoardToPlaceAMarker() {

        NotFullTestBoard notFullBoard = new NotFullTestBoard();
        IO quitIO = new QuitIO();
        Game testGame = new Game(notFullBoard, new Player(Marker.X, "Player 1"), new Player(Marker.O, "Player 2"), quitIO, new QuitIO());

        testGame.play();

        boolean result =  notFullBoard.placeMarkerWasCalled;

        assertFalse(result);
    }


    @Test
    public void shouldPreventUserChoosingAFilledSquareAndThenAllowNextChoiceIfUnfilled() {
        TicTacToeBoard board = new TicTacToeBoard(3, new WinChecker());
        SquareNotAvailableTestIO countingIO = new SquareNotAvailableTestIO();
        Game testGame = new Game(board, new Player(Marker.X, "Player 1"), new Player(Marker.O, "Player 2"), countingIO, new QuitIO());
        board.placeMarker(Marker.X, 5);

        testGame.play();

        String result = board.toString();
        String expected = "12X\n4X6\n789\n";

        assertEquals(expected, result);

    }

    class FullTestBoard implements Board {

        private final int size;
        private final WinChecker checker;

        FullTestBoard(int boardSize, WinChecker checker) {
            this.size = boardSize;
            this.checker = checker;
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
            return true;
        }

        @Override
        public void placeMarker(Marker marker, int markerPlacement) {}

        @Override
        public boolean gameIsWon() {
            return false;
        }
    }

    class NotFullTestBoard implements Board {

        boolean placeMarkerWasCalled;

        @Override
        public int getSize() {
            return 0;
        }

        @Override
        public boolean isFull() {
            return false;
        }

        @Override
        public boolean squareIsAvailable(int markerPlacement) {
            return false;
        }

        @Override
        public void placeMarker(Marker marker, int markerPlacement) {
            this.placeMarkerWasCalled = true;
        }

        @Override
        public boolean gameIsWon() {
            return false;
        }
    }

    class SquareNotAvailableTestIO implements IO {

        int count = 0;
        int[] moves = {5,3};
        @Override
        public void print(String message) {}

        @Override
        public int getNextMove(int rangeMin, int rangeMax) {
            return moves[count++];
        }
    }



    class QuitIO implements IO {

        boolean printWasCalledWithExitMessage;

        @Override
        public void print(String message) {
            this.printWasCalledWithExitMessage = message.equals("Goodbye!");
        }

        boolean getPrintWasCalledWithExitMessage() {
            return this.printWasCalledWithExitMessage;
        }

        @Override
        public int getNextMove(int rangeMin, int rangeMax) {
            return 0;
        }
    }

    class DrawIO implements IO {

        boolean printWasCalledWithDrawMessage;

        boolean getPrintWasCalledWithDrawMessage() {
            return this.printWasCalledWithDrawMessage;
        }

        @Override
        public void print(String message) {
            this.printWasCalledWithDrawMessage = message.equals("Game was a draw.");
        }

        @Override
        public int getNextMove(int rangeMin, int rangeMax) {
            return 1;
        }
    }
}