package com.ness;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void canReverseAString() {
        String input = "Friday";
        String expected = "yadirF";
        Main m = new Main();
        String actual = m.reverse(input);

        assertEquals(expected, actual);

    }
}