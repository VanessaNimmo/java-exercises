package com.ness.payslipgenerator;

class Employee {

    private final String firstName, lastName;
    private final int annualSalary;
    private final long superRate;

    Employee(String firstName, String lastName, int annualSalary, long superRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
        this.superRate = superRate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    int getAnnualSalary() {
        return annualSalary;
    }

    public long getSuperRate() {
        return superRate;
    }
}
