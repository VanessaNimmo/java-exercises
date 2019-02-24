package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void shouldBeEmptyWhenCreated() {
        Square one = new Square();

        boolean result = one.isEmpty;

        assertTrue(result);
    }

    @Test
    public void shouldReturnADisplayValue() {
        Square one = new Square();

        String displayValue = one.displayValue;

        assertEquals(".", displayValue);
    }

}