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
        InputStream source = System.in;
        Scanner reader = new Scanner(source);

        Employee person = new Employee();

        System.out.println("Please enter your first name:");
        String firstName = reader.nextLine();

        System.out.println("Please enter your last name:");
        String lastName = reader.nextLine();

        person.setFirstName(firstName);
        person.setLastName(lastName);

        System.out.println("Hi " + person.getFirstName() + " " + person.getLastName() + "!");

        int annualSalary = getPositiveInteger("annual salary");
        float superRate = getPositiveFloat("super rate");


        System.out.println(annualSalary);
        System.out.println(superRate);

        // Do calculations

        // Present information

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