package com.ness.payslipgenerator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TaxTableTest {

    private final List<TaxBracket> taxBrackets;
    private final TaxTable taxTable;

    public TaxTableTest() {
        this.taxBrackets = new ArrayList<>();
        taxBrackets.add(new TaxBracket(0, 18200, 0, 0, 0));
        this.taxTable = new TaxTable(taxBrackets);
    }

    @Test
    public void returnsLowestTaxBracketFor0() {
        TaxBracket correctTaxBracket = taxTable.getTaxBracket(0);

        assertEquals(correctTaxBracket.getUpperLimit(), 18200);
    }

    @Test
    public void returnsLowerTaxBracketFor18200() {
        TaxBracket correctTaxBracket = taxTable.getTaxBracket(18200);

        assertEquals(correctTaxBracket.getUpperLimit(), 18200);
    }
}