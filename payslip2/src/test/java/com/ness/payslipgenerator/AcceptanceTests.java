package com.ness.payslipgenerator;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AcceptanceTests {

    private List<TaxBracket> taxBrackets;

    @Test
    public void givenAnEmployeeAndTaxRateItCalculatesIncomeTax() {
        PayCalculator payCalculator = new PayCalculator();
        Employee employee = new Employee("John", "Doe", (long) 60050, 9);
        TaxTable taxTable = new TaxTable(taxBrackets);
        Pay employeePay = payCalculator.calculate(employee, taxTable);

        BigDecimal incomeTax = BigDecimal.valueOf(922);

        assertEquals(incomeTax, employeePay.getIncomeTax());
    }
}
