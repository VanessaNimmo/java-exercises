package com.company;

public class Tax {

    public long incomeTax, netIncome, grossMonthlySalary, superAmount;
    private int baseAmount, overAmount;
    private double rateAbove;

    public long getIncomeTax() { return this.incomeTax; }
    public long getNetIncome() { return this.netIncome; }
    public int getGrossMonthlySalary() { return (int) this.grossMonthlySalary; }
    public long getSuperAmount() { return this.superAmount; }


    public Tax(int annualSalary, float superRate) {
        this.getTaxBracket(annualSalary);
        this.grossMonthlySalary = Math.toIntExact(Math.round(annualSalary / 12.0));
        this.incomeTax = this.calculateTax(annualSalary);
        this.netIncome = grossMonthlySalary - incomeTax;
        this.superAmount = Math.round(this.grossMonthlySalary * (superRate/100));
    }

    private void getTaxBracket(int annualSalary) {
        if (annualSalary > 180001) {
            this.baseAmount = 54232;
            this.rateAbove = 0.45;
        } else if (annualSalary > 87000) {
            this.baseAmount = 19822;
            this.rateAbove = 0.37;
            this.overAmount = 87000;
        } else if (annualSalary > 37000) {
            this.baseAmount = 3572;
            this.rateAbove = 0.325;
            this.overAmount = 37000;
        } else if (annualSalary > 18200) {
            this.baseAmount = 0;
            this.rateAbove = 0.19;
            this.overAmount = 18200;
        } else {
            this.baseAmount = 0;
            this.rateAbove = 0;
            this.overAmount = 0;
        }
    }

    private long calculateTax(int annualSalary) {
        int amountToTax = annualSalary - this.overAmount;
        double monthlyTaxAmount = (this.baseAmount + (amountToTax*this.rateAbove))/12;
        return Math.round(monthlyTaxAmount);
    }
}