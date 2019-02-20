package com.ness;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void addTakesAStringAndReturnsANumber() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void aSingleNumberReturnsThatNumber() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void aDifferentSingleNumberReturnsThatNumber() {
        assertEquals(3, StringCalculator.add("3"));
    }

    @Test
    public void twoNumbersReturnTheSumOfTheNumbers() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void anyAmountOfNumbersReturnsThoseNumbers() {
        assertEquals(6, StringCalculator.add("1,2,3"));
    }

    @Test
    public void anyAmountOfNumbersReturnsThoseNumbersAdditionalTest() {
        assertEquals(20, StringCalculator.add("3,5,3,9"));
    }

    @Test
    public void newLineBreaksAndCommasShouldBeInterchangableBetweenNumbers() {
        assertEquals(6, StringCalculator.add("1,2\n3"));
    }

    @Test
    public void newLineBreaksAndCommasShouldBeInterchangeableAdditionalTest() {
        assertEquals(20, StringCalculator.add("3\n5\n3,9"));
    }

    @Test
    public void takesAnAlternateDelimiterAtTheStartOfTheStringFlaggedWithForwardSlashes() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
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
        assertEquals(2, StringCalculator.add("1000,1001,2"));
    }

    @Test
    public void delimitersCanBeOfAnyLength() {
        assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void allowMultipleDelimiters() {
        assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void handleMultipleDelimitersWithLengthGreaterThanOneCharacter() {
        assertEquals(10, StringCalculator.add("//[***][#][%]\n1***2#3%4"));
    }

    @Test
    public void handleDelimitersThatHaveNumbersInside() {
        assertEquals(6, StringCalculator.add("//[*1*][%]\n1*1*2%3"));
    }
}