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
    public void shouldReturnCurrentStateOfGameAsArrayOfArrays() {
        Board tictactoe = new Board(3);

        char[][] result = tictactoe.state;

        char[][] expectedState = new char[][] {{'.', '.', '.'}, {'.', '.', '.'}, {'.', '.', '.'}};

        assertArrayEquals(expectedState, result);
    }

    @Test
    public void afterAcceptingAMoveBoardStateShouldChange() {
        Board tictactoe = new Board(3);
        char entry = 'X', column = 1, row = 2;
        tictactoe.move(entry, column, row);

        char[][] result = tictactoe.state;

        char[][] expectedState = new char[][] {{'.', '.', '.'}, {'.', '.', 'X'}, {'.', '.', '.'}};

        assertArrayEquals(expectedState, result);
    }

}