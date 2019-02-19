package com.company;

public class Pay {

    public int annualSalary;
    public float superRate;
    public String payPeriodStart, payPeriodEnd;

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