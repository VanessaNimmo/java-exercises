package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class MarkerTest {

    @Test
    public void typeXHasValueOfStringX () {
        Marker marker1 = Marker.X;

        String result = String.valueOf(marker1);

        assertEquals("X", result);
    }
}