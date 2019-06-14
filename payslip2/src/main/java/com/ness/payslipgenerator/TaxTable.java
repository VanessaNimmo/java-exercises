package com.ness.payslipgenerator;

import java.util.List;

public class TaxTable {

    private final List<TaxBracket> taxBrackets;

    TaxTable(List<TaxBracket> taxBrackets) {
        this.taxBrackets = taxBrackets;
    }

    public TaxBracket getTaxBracket(int totalPay) {
        TaxBracket correctBracket = taxBrackets.get(taxBrackets.size() - 1);
        for (int i = 0; i < taxBrackets.size() - 1; i++) {
            correctBracket = payFitsInBracket(totalPay, i) ? taxBrackets.get(i) : correctBracket;
        }
        return correctBracket;
    }

    private boolean payFitsInBracket(int totalPay, int i) {
        return totalPay >= taxBrackets.get(i).getLowerLimit() && totalPay < taxBrackets.get(i + 1).getLowerLimit();
    }
}
