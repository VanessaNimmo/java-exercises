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

}