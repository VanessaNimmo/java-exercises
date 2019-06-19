package com.ness.payslipgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class GetInputObjects {

    private final IInput input;
    private final IOutput output;

    public GetInputObjects(IInput input, IOutput output) {
        this.input = input;
        this.output = output;
    }

    Optional<Employee> getEmployee() {
        try {
            output.print("Please input your first name: ");
            String firstName = input.getInput();
            output.print("Please input your surname: ");
            String lastName = input.getInput();
            output.print("Please enter your annual salary: ");
            Integer annualSalary = Integer.parseInt(input.getInput());
            output.print("Please enter your super rate as a percentage: ");
            double superRate = Double.parseDouble(input.getInput());
            return Optional.of(new Employee(firstName, lastName, annualSalary, superRate));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    TaxTable getTaxTable() {
        List<TaxBracket> taxBrackets = new ArrayList<>();
        taxBrackets.add(new TaxBracket(0, 0, 0, 0));
        taxBrackets.add(new TaxBracket(18201, 0, 18200, 0.19));
        taxBrackets.add(new TaxBracket(37001, 3572, 37000, 0.325));
        taxBrackets.add(new TaxBracket(87001, 19822, 87000, 0.37));
        taxBrackets.add(new TaxBracket(180001, 54232, 180000, 0.45));
        return new TaxTable(taxBrackets);
    }

    Optional<PayPeriod> getPayPeriod() {
        Pattern payPeriodFormat = Pattern.compile("(\\d*)(\\s)(\\w*)");
        output.print("Please enter your payment start date: ");
        String startDate = correctDateString(payPeriodFormat);
        output.print("Please enter your payment end date: ");
        String endDate = correctDateString(payPeriodFormat);
        PayPeriod payPeriod = new PayPeriod(startDate, endDate);
        if (payPeriod.isValidMonthPeriod()) {
            return Optional.of(payPeriod);
        }
        return Optional.empty();
    }

    private String correctDateString(Pattern payPeriodFormat) {
        String response = input.getInput();
        while (!payPeriodFormat.matcher(response).matches()) {
            output.print("Please use the format '1 March' to enter dates: ");
            response = input.getInput();
        }
        return response;
    }
}
