package com.ness.payslipgenerator;

public class PayCalculator {

    private final Employee employee;
    private final TaxTable taxTable;
    private TaxBracket taxBracket;
    private PayPeriod payPeriod;

    PayCalculator(Employee employee, TaxTable taxTable, PayPeriod payPeriod) {
        this.payPeriod = payPeriod;
        this.employee = employee;
        this.taxTable = taxTable;
        this.taxBracket = taxTable.getTaxBracket(employee.getAnnualSalary());
    }

    public Pay calculate() {
        int grossIncome = calculateGrossIncome((long)employee.getAnnualSalary());
        int incomeTax = calculateIncomeTax();
        int netIncome = calculateNetIncome(grossIncome, incomeTax);
        int superPayment = calculateSuper(grossIncome, employee.getSuperRate());
        return new Pay(payPeriod, grossIncome, incomeTax, netIncome,  superPayment);
    }

    private int calculateSuper(int grossIncome, double superRate) {
        superRate = superRate/100;
        return (int) Math.round(grossIncome * superRate);
    }

    private int calculateGrossIncome(long annualSalary) {
        return Math.round(annualSalary/12);
    }

    private int calculateIncomeTax() {
        double amountOver = employee.getAnnualSalary() - taxBracket.getStartOfPerDollar();
        double yearlyTax = taxBracket.getBaseAmount() + (amountOver * taxBracket.getPerDollarAmount());
        return (int) Math.round(yearlyTax/12);
    }

    private int calculateNetIncome(int grossIncome, int incomeTax) {
        return grossIncome - incomeTax;
    }
}
