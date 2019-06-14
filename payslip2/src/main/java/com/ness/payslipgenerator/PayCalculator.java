package com.ness.payslipgenerator;

public class PayCalculator {

    public Pay calculate(Employee employee, TaxTable taxTable) {
        int grossIncome = calculateGrossIncome(employee.getAnnualSalary());
        return new Pay(grossIncome);
    }

    private int calculateGrossIncome(long annualSalary) {
        return Math.round(annualSalary/12);
    }
}
