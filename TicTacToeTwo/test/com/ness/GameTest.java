package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

//    @Test
//    public void gameShouldEndGameWithDrawConditionIfBoardIsFull() {
//        int boardSize = 3;
//        WinChecker checker = new WinChecker();
//        Board fullBoard = new FullTestBoard(boardSize, checker);
//        Game testGame = new Game(fullBoard, new Player(Marker.X, "Player 1"), new Player(Marker.O, "Player 2"), new TestIO(), new TestIO());
//
//        testGame.play();
//
//        // could check that it sends a call the endGame that has the draw condition message?
//
//    }

    @Test
    public void shouldAllowUserToQuitAnyTimeUsingq() {

        Board notFullBoard = new NotFullTestBoard();
        IO quitIO = new QuitIO();
        Game testGame = new Game(notFullBoard, new Player(Marker.X, "Player 1"), new Player(Marker.O, "Player 2"), quitIO, new QuitIO());

        testGame.play();

        boolean result = ((QuitIO) quitIO).getPrintWasCalledWithExitMessage();

        assertTrue(result);
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
            return false;
        }

        @Override
        public void placeMarker(Marker marker, int markerPlacement) {}

        @Override
        public boolean gameIsWon() {
            return false;
        }
    }

    class NotFullTestBoard implements Board {

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

        }

        @Override
        public boolean gameIsWon() {
            return false;
        }
    }

    class TestIO implements IO {
        // does it print the goodbye message?
        public boolean printWasCalledWithDrawMessage;

        @Override
        public void print(String message) {

        }

        @Override
        public int getNextMove(int rangeMin, int rangeMax) {
            return 0;
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
}