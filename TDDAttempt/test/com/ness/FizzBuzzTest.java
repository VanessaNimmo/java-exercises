package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {

    @Test
    public void shouldReturn1WhenGiven1() {
        FizzBuzz fizzbuzz = new FizzBuzz();

        String result = fizzbuzz.check(1);

        assertEquals("1", result);
    }

    @Test
    public void shouldReturn2WhenGiven2() {
        FizzBuzz fizzbuzz = new FizzBuzz();

        String result = fizzbuzz.check(2);

        assertEquals("2", result);
    }
}