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
    public void shouldReturnTrueWhenMoveIsOnTheBoard() {
        Board tictactoe = new Board(3);
        int column = 0;
        int row = 0;

        boolean result = tictactoe.moveIsOnBoard(column, row);

        assertEquals(true, result);
    }

    @Test
    public void shouldReturnFalseWhenMoveIsOffTheBoard() {
        Board tictactoe = new Board(3);
        int column = 3;
        int row = 1;

        boolean result = tictactoe.moveIsOnBoard(column, row);

        assertEquals(false, result);
    }

    @Test
    public void shouldReturnCurrentStateOfGameAsArrayOfArraysOfSquareObjects() {
        int boardSize = 3;
        Board tictactoe = new Board(boardSize);

        Square[][] result = tictactoe.state;

        assertTrue(result[0][0] instanceof Square);
    }

    @Test
    public void afterAcceptingAMoveBoardStateShouldChange() {
        int boardSize = 3;
        Board tictactoe = new Board(boardSize);
        char entry = 'X';
        int column = 1;
        int row = 2;
        tictactoe.move(entry, column, row);

        char result = tictactoe.state[column][row].displayValue;

        Square[][] expectedState = new Square[boardSize][boardSize];
        for(int i=0; i<boardSize; i++) {
            for(int j=0; j<boardSize; j++) expectedState[i][j] = new Square();
        }
        expectedState[column][row].makeEntry('X');
        char expectedDisplayValue = expectedState[column][row].displayValue;

        assertEquals(expectedDisplayValue, result);
    }

}