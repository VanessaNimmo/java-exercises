package com.ness.payslipgenerator;

public class Pay {

    private final PayPeriod payPeriod;
    private final int grossIncome, incomeTax, netIncome;

    Pay(PayPeriod payPeriod, int grossIncome, int incomeTax, int netIncome) {
        this.payPeriod = payPeriod;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
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
}
