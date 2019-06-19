package com.ness.payslipgenerator;

import java.util.Optional;

public class PaySlipGenerator {

    public static void main(String[] args) {

        IInput input = new ConsoleIn();
        IOutput output = new ConsoleOut();
        output.print(String.format("Welcome to the payslip generator!%n"));
        GetInputObjects inputManager = new GetInputObjects(input, output);
        Optional<Employee> employee = inputManager.getEmployee();
        Optional<PayPeriod> payPeriod = inputManager.getPayPeriod();
        if (employee.isPresent() && payPeriod.isPresent()) {
            TaxTable taxTable = inputManager.getTaxTable();
            PayCalculator payCalculator = new PayCalculator(employee.get(), taxTable, payPeriod.get());
            Pay pay = payCalculator.calculate();
            output.print(pay.paySlip(employee.get()));
            output.print(String.format("Thank you for using MYOB!%n"));
        } else {
            output.print(String.format("Something went wrong during data input. Program exiting.%n"));
        }
    }
}
