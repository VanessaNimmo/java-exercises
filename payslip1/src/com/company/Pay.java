package com.company;

public class Pay {

    public int annualSalary, grossMonthlySalary, superAmount;
    public long incomeTax, netIncome;
    public float superRate;
    public String payPeriodStart, payPeriodEnd;

    public void setSalary(int annualSalary) {
        this.annualSalary = annualSalary;
        this.grossMonthlySalary = Math.toIntExact(Math.round(annualSalary / 12.0));
        this.incomeTax = this.calculateTax();
        this.netIncome = grossMonthlySalary - incomeTax;
    };

    public void setSuper(float superRate) {
        this.superRate = superRate;
        this.superAmount = Math.round(this.grossMonthlySalary * (superRate/100));
    }

    public void setPayPeriodStart(String payPeriodStart) { this.payPeriodStart = payPeriodStart; }
    public void setPayPeriodEnd(String payPeriodEnd) { this.payPeriodEnd = payPeriodEnd; }

    public String getPayPeriod() { return (this.payPeriodStart + " - " + this.payPeriodEnd); }
    public int getGrossMonthlySalary() { return this.grossMonthlySalary; }
    public long getIncomeTax() { return this.incomeTax; }
    public long getNetIncome() { return this.netIncome; }
    public int getSuperAmount() { return this.superAmount; }

    private long calculateTax() {
        // Do tax calculations here
        long tax = 0;
        int baseAmount = 0;
        double rateAbove = 0;
        int overAmount = 0;
        if (this.annualSalary > 180001) {
            baseAmount = 54232;
            rateAbove = 0.45;
        } else if (this.annualSalary > 87000) {
            baseAmount = 19822;
            rateAbove = 0.37;
            overAmount = 87000;
        } else if (this.annualSalary > 37000) {
            baseAmount = 3572;
            rateAbove = 0.325;
            overAmount = 37000;
        } else if (this.annualSalary > 18200) {
            baseAmount = 0;
            rateAbove = 0.19;
            overAmount = 18200;
        }
        int amountToTax = this.annualSalary - overAmount;
        double monthlyTaxAmount = (baseAmount + (amountToTax*rateAbove))/12;
        tax = Math.round(monthlyTaxAmount);
        return tax;
    }

}