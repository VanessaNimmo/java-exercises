package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputOutputTest {

    @Test
    public void shouldAcceptAStartGameDirectiveWhichTriggersAWelcomeMessage() {
        InputOutput io = new InputOutput();

        String result = io.startGame("TicTacToe!");

        assertEquals("Welcome to TicTacToe!", result);
    }

}