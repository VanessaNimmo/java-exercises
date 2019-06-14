package com.ness.payslipgenerator;

public class TaxBracket {

    private final double lowerLimit;
    private final double baseAmount;
    private final double startOfPerDollar;
    private final double perDollarAmount;

    public TaxBracket(double lowerLimit, double baseAmount, double startOfPerDollar, double perDollarAmount) {
        this.lowerLimit = lowerLimit;
        this.baseAmount = baseAmount;
        this.startOfPerDollar = startOfPerDollar;
        this.perDollarAmount = perDollarAmount;
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public double getBaseAmount() {
        return baseAmount;
    }

    public double getStartOfPerDollar() {
        return startOfPerDollar;
    }

    public double getPerDollarAmount() {
        return perDollarAmount;
    }
}
