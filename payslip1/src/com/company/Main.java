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

        person.setFirstName(firstName);

        System.out.println(person.getFirstName());




        // Do calculations

        // Present information

    }



}

class Employee {

    public String firstName, lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

}