package com.ness;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConwaysTest {

    private InputOutput io;
    private Game conwaysGame;

    @Before
    public void setUp() {
        this.io = new ConsoleIO();
        this.conwaysGame = new Game(this.io);
    }

    @Test
    public void shouldSendAWelcomeMessageToOutput() {

        boolean messageSent = conwaysGame.io.sendWelcome("Welcome to Conway's Game of Life");

        assertTrue(messageSent);
    }

    @Test
    public void shouldGetInitialLiveCellsFromIO() {

        boolean[][] result = conwaysGame.io.getInitialLiveCells();
        boolean[][] expected = {{false, false, false, false}, {false, true, false, false}, {false, false, false, true}, {false, false, false, false}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void shouldCreateBoardWithInitialState() {

        boolean [][] initialLiveCells = {{false, false, false, false}, {false, true, false, false}, {false, false, false, true}, {false, false, false, false}};

        Board result = conwaysGame.newBoard(initialLiveCells);

        assertNotNull(result);
    }

    @Test
    public void shouldCalculateNextStateOfWorldWhenGivenABoard() {
        boolean [][] initialLiveCells = {{false, false, false, false}, {false, true, false, false}, {false, false, false, true}, {false, false, false, false}};

        Board oldBoard = conwaysGame.newBoard(initialLiveCells);

        boolean[][] result = conwaysGame.calculateNext(oldBoard);
        boolean[][] expected = {{false, false, false, false}, {false, false, false, false}, {false, false, false, false}, {false, false, false, false}};

        assertArrayEquals(expected, result);
    }

    @Test
    public void calculateNextStateWithMoreComplexBoard() {
        boolean[][] initialLiveCells = {{false, true, false, false}, {false, true, true, false}, {false, false, false, false}, {false, true, false, false}};

        Board oldBoard = conwaysGame.newBoard(initialLiveCells);
        boolean[][] result = conwaysGame.calculateNext(oldBoard);
        boolean[][] expected = {{false, true, false, false}, {false, false, true, false}, {false, true, true, false}, {false, false, false, false}};

        assertArrayEquals(expected, result);
    }

}