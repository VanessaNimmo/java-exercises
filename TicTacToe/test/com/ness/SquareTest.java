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

        char result = one.displayValue;

        assertEquals('*', result);
    }

    @Test
    public void shouldAcceptAMoveIfEmptyAndChangeDisplayValue() {
        Square one = new Square();
        char entry = 'X';

        one.makeEntry(entry);
        char result1 = one.displayValue;

        assertEquals('X', result1);

    }

    @Test
    public void shouldChangeIsEmptyToFalseWhenAcceptsADisplayValue() {
        Square one = new Square();
        char entry = 'O';

        one.makeEntry(entry);
        boolean result = one.isEmpty;

        assertFalse(result);
    }
}