package com.ness.payslipgenerator;

public class ConsoleOut implements IOutput {

    @Override
    public void print(String message) {
        System.out.print(message);
    }
}
