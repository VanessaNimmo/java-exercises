package com.ness.payslipgenerator;

public class TaxBracket {

    private final long lowerLimit;
    private final long upperLimit;
    private final long baseAmount;
    private final long startOfPerDollar;
    private final long perDollarAmount;

    public TaxBracket(long lowerLimit, long upperLimit, long baseAmount, long startOfPerDollar, long perDollarAmount) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.baseAmount = baseAmount;
        this.startOfPerDollar = startOfPerDollar;
        this.perDollarAmount = perDollarAmount;
    }

    public long getLowerLimit() {
        return lowerLimit;
    }

    public long getUpperLimit() {
        return upperLimit;
    }

    public long getBaseAmount() {
        return baseAmount;
    }

    public long getStartOfPerDollar() {
        return startOfPerDollar;
    }

    public long getPerDollarAmount() {
        return perDollarAmount;
    }
}
