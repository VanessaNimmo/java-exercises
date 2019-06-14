package com.ness.payslipgenerator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TaxTableTest {

    private final TaxTable taxTable;

    public TaxTableTest() {
        List<TaxBracket> taxBrackets = new ArrayList<>();
        taxBrackets.add(new TaxBracket(0, 0, 0, 0));
        taxBrackets.add(new TaxBracket(18201, 0, 18200, 19));
        taxBrackets.add(new TaxBracket(37001, 3572, 37000, 32.5));
        taxBrackets.add(new TaxBracket(87001, 19822, 87000, 32));
        taxBrackets.add(new TaxBracket(180001, 54232, 180000, 45));
        this.taxTable = new TaxTable(taxBrackets);
    }

    @Test
    public void returnsLowestTaxBracketFor0() {
        TaxBracket correctTaxBracket = taxTable.getTaxBracket(0);

        assertEquals((double)0, correctTaxBracket.getLowerLimit());
    }

    @Test
    public void returnsLowerTaxBracketFor18200() {
        TaxBracket correctTaxBracket = taxTable.getTaxBracket(18200);

        assertEquals((double)0, correctTaxBracket.getLowerLimit());
    }

    @Test
    public void returnsSecondTaxBracketFor18201() {
        TaxBracket correctTaxBracket = taxTable.getTaxBracket(18201);

        assertEquals((double)18201, correctTaxBracket.getLowerLimit());
    }

    @Test
    public void returnsSecondTaxBracketFor37000() {
        TaxBracket correctTaxBracket = taxTable.getTaxBracket(37000);

        assertEquals((double)18201, correctTaxBracket.getLowerLimit());
    }

    @Test
    public void returnsThirdTaxBracketFor37001() {
        TaxBracket correctTaxBracket = taxTable.getTaxBracket(37001);

        assertEquals((double)37001, correctTaxBracket.getLowerLimit());
    }

    @Test
    public void returnsThirdTaxBracketFor87000() {
        TaxBracket correctTaxBracket = taxTable.getTaxBracket(87000);

        assertEquals((double)37001, correctTaxBracket.getLowerLimit());
    }

    @Test
    public void returnsFourthTaxBracketFor87001() {
        TaxBracket correctTaxBracket = taxTable.getTaxBracket(87001);

        assertEquals((double)87001, correctTaxBracket.getLowerLimit());
    }

    @Test
    public void returnsFourthTaxBracketFor180000() {
        TaxBracket correctTaxBracket = taxTable.getTaxBracket(180000);

        assertEquals((double)87001, correctTaxBracket.getLowerLimit());
    }

    @Test
    public void returnsFifthTaxBracketFor180001() {
        TaxBracket correctTaxBracket = taxTable.getTaxBracket(180001);

        assertEquals((double)180001, correctTaxBracket.getLowerLimit());
    }
}