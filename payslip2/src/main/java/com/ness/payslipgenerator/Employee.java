package com.ness.payslipgenerator;

class Employee {

    private final String firstName, lastName;
    private final long annualSalary, superRate;

    Employee(String firstName, String lastName, long annualSalary, long superRate) {
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

    public long getAnnualSalary() {
        return annualSalary;
    }

    public long getSuperRate() {
        return superRate;
    }
}
