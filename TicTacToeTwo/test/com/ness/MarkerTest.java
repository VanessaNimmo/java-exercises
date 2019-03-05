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

    @Test
    public void typeOHasValueOfStringO () {
        Marker marker1 = Marker.O;

        String result = String.valueOf(marker1);

        assertEquals("Y", result);
    }

    @Test
    public void typePlaceHolderEHasValueOfStringAsterisk () {
        Marker marker1 = Marker.E;

        String result = String.valueOf(marker1);

        assertEquals("*", result);
    }
}