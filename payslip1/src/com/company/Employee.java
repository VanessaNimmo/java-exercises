package com.company;

public class Employee {

    public String firstName, lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() { return this.lastName; }

    public String getFullName() { return (this.firstName + " " + this.lastName); }

}