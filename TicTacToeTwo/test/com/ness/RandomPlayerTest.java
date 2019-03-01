package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomPlayerTest {

    @Test
    public void shouldReturnAnIntegerBetween1AndTheSquareOfTheBoardSize() {
        RandomPlayer player1 = new RandomPlayer("X", "Player 1");
        int boardSize = 3;
        int squareOfBoardSize = boardSize*boardSize;
        int result = player1.choosePosition(boardSize);

        assertTrue(1<= result && result <= squareOfBoardSize);
    }
}