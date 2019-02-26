package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void shouldReturnAnIntegerBetween1AndTheSquareOfTheBoardSize() {
        Player player1 = new Player("X");

        int result = player1.choosePosition(3);

        assertEquals(4, result);

    }
}