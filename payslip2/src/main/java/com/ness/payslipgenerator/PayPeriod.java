package com.ness.payslipgenerator;

import java.util.Calendar;
import java.util.HashMap;

public class PayPeriod {

    private final String fullDate;
    private HashMap<String, Integer> monthNumber;
    private int startMonth, endMonth;
    private long days;

    String getFullDate() { return fullDate; }

    PayPeriod(String start, String end) {
        this.monthNumber = new HashMap<>();
        monthNumber.put("January", Calendar.JANUARY);
        monthNumber.put("February", Calendar.FEBRUARY);
        monthNumber.put("March", Calendar.MARCH);
        monthNumber.put("April", Calendar.APRIL);
        monthNumber.put("May", Calendar.MAY);
        monthNumber.put("June", Calendar.JUNE);
        monthNumber.put("July", Calendar.JULY);
        monthNumber.put("August", Calendar.AUGUST);
        monthNumber.put("September", Calendar.SEPTEMBER);
        monthNumber.put("October", Calendar.OCTOBER);
        monthNumber.put("November", Calendar.NOVEMBER);
        monthNumber.put("December", Calendar.DECEMBER);
        this.startMonth = getMonth(start);
        int startDay = getDay(start);
        this.endMonth = getMonth(end);
        int endDay = getDay(end);
        this.days = endDay - startDay;
        start = addLeadingZero(startDay, start);
        end = addLeadingZero(endDay, end);
        this.fullDate = start + " - " + end;
    }

    private String addLeadingZero(int day,  String date) {
        return day < 10 ? "0" + date : date;
    }

    public boolean isValidMonthPeriod() {
        if (startMonth != endMonth) {
            return false;
        }
        boolean validNumberOfDays;
        switch (startMonth) {
            case 1:
                validNumberOfDays = this.days == 27 | this.days == 28;
                break;
            case 3:
            case 5:
            case 8:
            case 10:
                validNumberOfDays = this.days == 29;
                break;
            default:
                validNumberOfDays = this.days == 30;

        }
        return validNumberOfDays;
    }

    private int getDay(String dateEntered) {
        return Integer.parseInt(dateEntered.split(" ")[0]);
    }

    private int getMonth(String dateEntered) {
        return monthNumber.get(dateEntered.split(" ")[1]);
    }
}
