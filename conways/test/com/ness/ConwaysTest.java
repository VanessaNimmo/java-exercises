package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConwaysTest {

    @Test
    public void shouldSendAWelcomeMessageToOutput() {
        InputOutput io = new ConsoleIO();
        Game conwaysGame = new Game(io);

        boolean messageSent = conwaysGame.io.sendWelcome("Welcome to Conway's Game of Life");

        assertTrue(messageSent);
    }

    @Test
    public void shouldGetBoardSizeFromIO() {
        InputOutput io = new ConsoleIO();
        Game conwaysGame = new Game(io);

        int[] result = conwaysGame.io.getBoardSize();
        int[] expected = {10, 20};

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldGetInitialLiveCellsFromIO() {
        InputOutput io = new ConsoleIO();
        Game conwaysGame = new Game(io);

        boolean[][] result = conwaysGame.io.getInitialLiveCells();
        boolean[][] expected = {{false, false, false, false}, {false, true, false, false}, {false, false, false, true}, {false, false, false, false}};

        assertArrayEquals(expected, result);
    }

    
//    @Test
//    public void shouldInitaliseBoard() {
//        InputOutput io = new ConsoleIO();
//        Game conwaysGame = new Game(io);
//        int[] boardSize = {10,20};
//
//        Board result = game.newBoard(boardSize);
//
//        assertThat(result != null);
//    }

}