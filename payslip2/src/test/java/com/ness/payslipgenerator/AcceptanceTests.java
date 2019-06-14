package com.ness.payslipgenerator;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AcceptanceTests {

    private List<TaxBracket> taxBrackets;

    @Test
    public void givenAnEmployeeItCalculatesGrossPay() {
        PayCalculator payCalculator = new PayCalculator();
        Employee employee = new Employee("John", "Doe", (long) 60050, 9);
        TaxTable taxTable = new TaxTable(taxBrackets);
        Pay employeePay = payCalculator.calculate(employee, taxTable);

        assertEquals(5004, employeePay.getGrossIncome());
    }
}
