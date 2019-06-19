package com.ness.payslipgenerator;

import java.util.Scanner;

public class ConsoleIn implements IInput {

    @Override
    public String getInput() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

}
