package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void shouldBeInitalisedWithAToken() {
        Player player1 = new Player('O');

        char result = player1.token;

        assertEquals('O', result);
    }

}