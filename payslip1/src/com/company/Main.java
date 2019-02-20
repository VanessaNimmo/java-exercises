package com.company;

import java.io.InputStream;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        App app = new App();
        app.run();
    }
}

class App {

    public void run() {

        System.out.println("Welcome to the payslip generator!");

        // Get info from person, convert from strings to usable stuff

        String firstName = getString("first name");
        String lastName = getString("last name");
        Employee person = new Employee(firstName, lastName);

        System.out.println("Hi " + person.getFullName() + "!");

        int annualSalary = getPositiveInteger("annual salary");
        float superRate = getPositiveFloat("super rate");
        // Could possibly get in date and make a date object to check that the payslip applies to the tax rates given - Java docs are still a bit daunting
//        int payStartDay = getPositiveInteger("pay start date day");
//        int payStartMonth = getPositiveInteger("pay start date month");
//        int payStartYear = getPositiveInteger("pay start date year");
//        Date paymentStartDate = new Date(payStartDay, payStartMonth, payStartYear);

        String paymentStartDate = getString("payment start date");
        String paymentEndDate = getString("payment end date");

        /* Do calculations */

        Pay payDetails = new Pay(annualSalary, superRate, paymentStartDate, paymentEndDate);
        Tax taxDetails = new Tax(payDetails.getAnnualSalary(), payDetails.getSuperRate());

        // Present information

        String payslip = "Your payslip has been generated:\n" +
                "Name: " + person.getFullName() + "\n" +
                "Pay Period: " + payDetails.getPayPeriod() + "\n" +
                "Gross Income: " + taxDetails.getGrossMonthlySalary() + "\n" +
                "Income Tax: " + taxDetails.getIncomeTax() + "\n" +
                "Net Income: " + taxDetails.getNetIncome() + "\n" +
                "Super: " + taxDetails.getSuperAmount() + "\n\n" +
                "Thank you for using MYOB!";

        System.out.println(payslip);

    }

    private String getString(String stringFor) {

        InputStream source = System.in;
        Scanner reader = new Scanner(source);

        System.out.println("Please enter your " + stringFor + ":");
        return reader.nextLine();
    }

    private int getPositiveInteger(String numberFor) {

        InputStream source = System.in;
        Scanner reader = new Scanner(source);

        System.out.println("Please enter your " + numberFor + ":");
        int positiveInteger;
        do {
            while (!reader.hasNextInt()) {
                System.out.println("Please enter a positive number, digits only:");
                reader.next();
            }
            positiveInteger = reader.nextInt();
        } while (positiveInteger < 0);
        return positiveInteger;
    }

    private float getPositiveFloat(String numberFor) {

        InputStream source = System.in;
        Scanner reader = new Scanner(source);

        System.out.println("Please enter your " + numberFor + ":");
        float positiveFloat;
        do {
            while (!reader.hasNextFloat()) {
                System.out.println("Please enter a positive number:");
                reader.next();
            }
            positiveFloat = reader.nextFloat();
        } while (positiveFloat < 0);
        return positiveFloat;
    }
}