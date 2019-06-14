package com.ness.payslipgenerator;

public class Pay {

    private final int grossIncome;

    Pay(int grossIncome) {
        this.grossIncome = grossIncome;
    }

    public int getGrossIncome() {
        return grossIncome;
    }
}
