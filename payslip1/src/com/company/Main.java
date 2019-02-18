package com.company;

import java.io.InputStream;
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

        Employee person = new Employee();

        String firstName = getString("first name");
        String lastName = getString("last name");

        person.setFirstName(firstName);
        person.setLastName(lastName);

        System.out.println("Hi " + person.getFirstName() + " " + person.getLastName() + "!");

        int annualSalary = getPositiveInteger("annual salary");
        float superRate = getPositiveFloat("super rate");

        String paymentStartDate = getString("payment start date");
        String paymentEndDate = getString("payment end date");

        System.out.println(annualSalary);
        System.out.println(superRate);
        System.out.println(paymentStartDate);
        System.out.println(paymentEndDate);

        // Do calculations

        Pay payDetails = new Pay();
        payDetails.setSalary(annualSalary);
        payDetails.setSuper(superRate);
        payDetails.setPayPeriodStart(paymentStartDate);
        payDetails.setPayPeriodEnd(paymentEndDate);

        // Present information

        

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

class Employee {

    public String firstName, lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() { return this.lastName; }

}

class Pay {

    public Int annualSalary, grossMonthlySalary, incomeTax, netIncome, superRate, superAmount;
    public String payPeriodStart, payPeriodEnd;

    public void setSalary(Int annualSalary) {
        this.annualSalary = annualSalary;
        this.grossMonthlySalary = Math.round(annualSalary/12.0);
        this.incomeTax = this.calculateTax();
        this.netIncome = grossMonthlySalary - incomeTax;
    };

    public void setSuper(float superRate) {
        this.superRate = superRate;
        this.superAmount = Math.round(this.grossMonthlySalary * superRate);
    }

    public void setPayPeriodStart(String payPeriodStart) { this.payPeriodStart = payPeriodStart; }
    public void setPayPeriodEnd(String payPeriodEnd) { this.payPeriodEnd = payPeriodEnd; }

    public String getPayPeriod() { return (this.payPeriodStart + " - " + this.payPeriodEnd); }
    public Int getGrossMonthlySalary() { return this.grossMonthlySalary; }
    public Int getIncomeTax() { return this.incomeTax; }
    public Int getNetIncome() { return this.netIncome; }
    public Int getSuperAmount() { return this.superAmount; }


    private int calculateTax() {
        // Do tax calculations here
        return 5;
    }

}