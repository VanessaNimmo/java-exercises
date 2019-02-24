package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void shouldBeEmptyWhenCreate() {
        Square one = new Square();

        boolean result = one.isEmpty;

        assertTrue(result);
    }

}