package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void boardShouldBeEmptyAtStartOfGame () {
        int boardSize = 3;
        Board tictactoeBoard = new TicTacToeBoard(boardSize);
        char marker1 = 'X', marker2 = 'O';
        Player player1 = new Player(marker1);
        Player player2 = new Player(marker2);
        Game tictactoe = new Game(tictactoeBoard, player1, player2);

        String[][] expected = new String[boardSize][boardSize];
        String[][] result = tictactoe.board;

        assertArrayEquals(expected, result);
    }

}