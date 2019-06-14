package com.ness.payslipgenerator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PayCalculatorTest {

    private final TaxTable taxTable;

    public PayCalculatorTest() {
        List<TaxBracket> taxBrackets = new ArrayList<>();
        taxBrackets.add(new TaxBracket(0, 0, 0, 0));
        taxBrackets.add(new TaxBracket(18201, 0, 18200, 19));
        taxBrackets.add(new TaxBracket(37001, 3572, 37000, 32.5));
        taxBrackets.add(new TaxBracket(87001, 19822, 87000, 32));
        taxBrackets.add(new TaxBracket(180001, 54232, 180000, 45));
        this.taxTable = new TaxTable(taxBrackets);
    }

    @Test
    public void acceptsAnEmployeeAndTaxTableAndReturnsAPayObject() {
        Employee employee = new Employee("Jane", "Smith", (long)60050, 9);

        PayCalculator payCalculator = new PayCalculator();
        Pay pay = payCalculator.calculate(employee, taxTable);

        int expectedGrossIncome = 5004;

        assertEquals(expectedGrossIncome, pay.getGrossIncome());
    }
}