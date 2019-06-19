package com.ness.payslipgenerator;

import org.junit.Test;

import static org.junit.Assert.*;

public class PayPeriodTest {

    @Test
    public void acceptsStartAndEndDatesAndDeterminesIfValid() {
        PayPeriod payPeriod = new PayPeriod("1 March", "31 March");

        assertTrue(payPeriod.isValidMonthPeriod());
    }

    @Test
    public void formatsSingleDateNumbersWithLeadingZeros() {
        PayPeriod payPeriod = new PayPeriod("1 March", "31 March");

        String expectedFullDate = "01 March - 31 March";

        assertEquals(expectedFullDate, payPeriod.getFullDate());

    }
}