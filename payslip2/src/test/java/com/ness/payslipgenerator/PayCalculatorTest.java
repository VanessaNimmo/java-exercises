package com.ness.payslipgenerator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class PayCalculatorTest {

    private final TaxTable taxTable;
    private final PayPeriod payPeriod;

    public PayCalculatorTest() {
        List<TaxBracket> taxBrackets = new ArrayList<>();
        taxBrackets.add(new TaxBracket(0, 0, 0, 0));
        taxBrackets.add(new TaxBracket(18201, 0, 18200, 0.19));
        taxBrackets.add(new TaxBracket(37001, 3572, 37000, 0.325));
        taxBrackets.add(new TaxBracket(87001, 19822, 87000, 0.37));
        taxBrackets.add(new TaxBracket(180001, 54232, 180000, 0.45));
        this.taxTable = new TaxTable(taxBrackets);
        this.payPeriod = new PayPeriod("1 March", "31 March");
    }

    @Test
    public void acceptsAnEmployeeAndTaxTableAndCalculatesGrossIncome() {
        Employee employee = new Employee("Jane", "Smith", 60050, 9);

        PayCalculator payCalculator = new PayCalculator(employee, taxTable, payPeriod);
        Pay pay = payCalculator.calculate();

        int expectedGrossIncome = 5004;

        assertEquals(expectedGrossIncome, pay.getGrossIncome());
    }

    @Test
    public void acceptsAnEmployeeAndTaxTableAndCalculatesIncomeTax() {
        Employee employee = new Employee("Jane", "Smith", 60050, 9);

        PayCalculator payCalculator = new PayCalculator(employee, taxTable, payPeriod);
        Pay pay = payCalculator.calculate();

        int expectedIncomeTax = 922;

        assertEquals(expectedIncomeTax, pay.getIncomeTax());
    }

    @Test
    public void acceptsAnEmployeeAndTaxTableAndCalculatesNetIncome() {
        Employee employee = new Employee("Jane", "Smith", 60050, 9);

        PayCalculator payCalculator = new PayCalculator(employee, taxTable, payPeriod);
        Pay pay = payCalculator.calculate();

        int expectedNetIncome = 4082;

        assertEquals(expectedNetIncome, pay.getNetIncome());
    }

    @Test
    public void acceptsAnEmployeeAndTaxTableAndCalculatesSuper() {
        Employee employee = new Employee("Jane", "Smith", 60050, 9);

        PayCalculator payCalculator = new PayCalculator(employee, taxTable, payPeriod);
        Pay pay = payCalculator.calculate();

        int expectedSuper = 450;

        assertEquals(expectedSuper, pay.getSuper());
    }
}