package com.ness;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    /* Now using Arrange Act Assert as the structure for tests */
    @Test
    public void addTakesAStringAndReturnsANumber() {
        String input = "";

        int result = StringCalculator.add(input);

        assertEquals(0, result);
    }

    @Test
    public void aSingleNumberReturnsThatNumber() {
        String input = "1";

        int result = StringCalculator.add(input);

        assertEquals(1, result);
    }

    @Test
    public void aDifferentSingleNumberReturnsThatNumber() {
        String input = "3";

        int result = StringCalculator.add(input);

        assertEquals(3, result);
    }

    @Test
    public void twoNumbersReturnTheSumOfTheNumbers() {
        String input = "1,2";

        int result = StringCalculator.add(input);

        assertEquals(3, result);
    }

    @Test
    public void anyAmountOfNumbersReturnsThoseNumbers() {
        String input = "1,2,3";

        int result = StringCalculator.add(input);

        assertEquals(6, result);
    }

    @Test
    public void anyAmountOfNumbersReturnsThoseNumbersAdditionalTest() {
        String input = "3,5,3,9";

        int result = StringCalculator.add(input);

        assertEquals(20, result);
    }

    @Test
    public void newLineBreaksAndCommasShouldBeInterchangableBetweenNumbers() {
        String input = "1,2\n3";

        int result = StringCalculator.add(input);

        assertEquals(6, result);
    }

    @Test
    public void newLineBreaksAndCommasShouldBeInterchangeableAdditionalTest() {
        String input = "3\n5\n3,9";

        int result = StringCalculator.add(input);

        assertEquals(20, result);
    }

    @Test
    public void takesAnAlternateDelimiterAtTheStartOfTheStringFlaggedWithForwardSlashes() {
        String input = "//;\n1;2";

        int result = StringCalculator.add(input);

        assertEquals(3, result);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void throwsExceptionWhenNegativesIncluded() {
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Negatives not allowed: -1, -3" );
        StringCalculator.add("-1,2,-3");
    }

    @Test
    public void numbersGreaterThanOrEqualTo1000ShouldBeIgnored() {
        String input = "1000,1001,2";

        int result = StringCalculator.add(input);

        assertEquals(2, result);
    }

    @Test
    public void delimitersCanBeOfAnyLength() {
        String input = "//[***]\n1***2***3";

        int result = StringCalculator.add(input);

        assertEquals(6, result);
    }

    @Test
    public void allowMultipleDelimiters() {
        String input = "//[*][%]\n1*2%3";

        int result = StringCalculator.add(input);

        assertEquals(6, result);
    }

    @Test
    public void handleMultipleDelimitersWithLengthGreaterThanOneCharacter() {
        String input = "//[***][#][%]\n1***2#3%4";

        int result = StringCalculator.add(input);

        assertEquals(10, result);
    }

    @Test
    public void handleDelimitersThatHaveNumbersInside() {
        String input = "//[*1*][%]\n1*1*2%3";

        int result = StringCalculator.add(input);

        assertEquals(6, result);
    }
}