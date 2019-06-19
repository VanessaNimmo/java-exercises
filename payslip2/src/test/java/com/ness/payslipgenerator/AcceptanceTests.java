package com.ness.payslipgenerator;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AcceptanceTests {

    private List<TaxBracket> taxBrackets;

    @Test
    public void givenAnEmployeeItCalculatesGrossPay() {
        taxBrackets.add(new TaxBracket(0, 0, 0, 0));
        taxBrackets.add(new TaxBracket(18201, 0, 18200, 0.19));
        taxBrackets.add(new TaxBracket(37001, 3572, 37000, 0.325));
        taxBrackets.add(new TaxBracket(87001, 19822, 87000, 0.37));
        taxBrackets.add(new TaxBracket(180001, 54232, 180000, 0.45));

        Employee employee = new Employee("John", "Doe", 60050, 9);
        TaxTable taxTable = new TaxTable(taxBrackets);
        PayPeriod payPeriod = new PayPeriod("1 March", "31 March");
        PayCalculator payCalculator = new PayCalculator(employee, taxTable, payPeriod);
        Pay employeePay = payCalculator.calculate();

        assertEquals(5004, employeePay.getGrossIncome());
    }
}
