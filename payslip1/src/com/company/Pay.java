package com.company;

class Pay {

    private final int annualSalary;
    private final float superRate;
    private final String payPeriodStart, payPeriodEnd;

    public Pay(int annualSalary, float superRate, String paymentStartDate, String paymentEndDate) {
        this.annualSalary = annualSalary;
        this.superRate = superRate;
        this.payPeriodStart = paymentStartDate;
        this.payPeriodEnd = paymentEndDate;
    }

    public String getPayPeriod() { return (this.payPeriodStart + " - " + this.payPeriodEnd); }
    public float getSuperRate() { return this.superRate; }
    public int getAnnualSalary() { return this.annualSalary; }
}