package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void boardShouldBeEmptyAtStartOfGame () {
        Game tictactoe = new Game(board, player1, player2);

        boolean result = tictactoe.board.isEmpty();

        assertTrue(result);
    }

}