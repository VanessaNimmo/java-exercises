package com.ness;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void shouldCheckThatAGivenInputMatchesTheRequiredPattern() {
        Validator conwaysValidator = new Validator();

        boolean result = conwaysValidator.validInputString("5 5");

        assertTrue(result);
    }
}