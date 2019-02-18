package com.company;

public class Employee {

    public String firstName, lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() { return this.lastName; }

    public String getFullName() { return (this.firstName + " " + this.lastName); }

}