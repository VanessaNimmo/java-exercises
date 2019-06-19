package com.ness.payslipgenerator;

public class Pay {

    private final PayPeriod payPeriod;
    private final int grossIncome, incomeTax, netIncome, superPayment;

    Pay(PayPeriod payPeriod, int grossIncome, int incomeTax, int netIncome, int superPayment) {
        this.payPeriod = payPeriod;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.superPayment = superPayment;
    }

    public PayPeriod getPayPeriod() { return payPeriod; }

    public int getGrossIncome() {
        return grossIncome;
    }

    public int getIncomeTax() {
        return incomeTax;
    }

    public int getNetIncome() {
        return netIncome;
    }

    public int getSuper() { return superPayment; }

    String paySlip(Employee employee) {
        String paySlip = String.format(
                "Your payslip has been generated: %n%n" +
                        "Name: " + employee.getFullName() + "%n" +
                        "Pay Period: " + this.payPeriod.getFullDate() + "%n" +
                        "Gross Income: " + this.grossIncome + "%n" +
                        "Income Tax: " + this.incomeTax + "%n" +
                        "Net Income: " + this.netIncome + "%n" +
                        "Super: " + this.superPayment + "%n%n"
        );
        return paySlip;
    }
}
