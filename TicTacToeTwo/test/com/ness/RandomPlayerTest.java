package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class RandomPlayerTest {

    @Test
    public void shouldReturnAnIntegerBetween1AndTheSquareOfTheBoardSize() {
        Player player1 = new RandomPlayer("X");

        int result = player1.choosePosition(3);

        assertEquals(4, result);

    }
}