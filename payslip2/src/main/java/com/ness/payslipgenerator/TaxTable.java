package com.ness.payslipgenerator;

import java.util.List;
import java.util.stream.Collectors;

public class TaxTable {

    private final List<TaxBracket> taxBrackets;

    TaxTable(List<TaxBracket> taxBrackets) {
        this.taxBrackets = taxBrackets;
    }

    public TaxBracket getTaxBracket(int totalPay) {
        return taxBrackets.stream().filter(bracket -> payIsWithinBracket(totalPay, bracket)).collect(Collectors.toList()).get(0);
    }

    private boolean payIsWithinBracket(int totalPay, TaxBracket bracket) {
        return totalPay >= bracket.getLowerLimit() && totalPay <= bracket.getUpperLimit();
    }
}
