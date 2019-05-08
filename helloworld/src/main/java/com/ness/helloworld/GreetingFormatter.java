package com.ness.helloworld;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GreetingFormatter {

    public String createResponse(LocalDateTime time, NameList nameList) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma 'on' dd LLLL yyyy");
        String formattedDateTime = time.format(formatter);
        String formattedDateTimeWithLowercase = formattedDateTime.replace("AM", "am").replace("PM","pm");
        String greetings = makeGreetings(nameList.getList());
        String response = String.format("Hello %s - the time on the server is %s", greetings, formattedDateTimeWithLowercase);
        return response;
    }

    private String makeGreetings(ArrayList<String> nameList) {
        if (nameList.size()==1) {
            return String.format("%s", nameList.get(0));
        } else if (nameList.size()==2) {
            return String.format("%s and %s", nameList.get(0), nameList.get(1));
        }
        return makeLongerList(nameList);
    }

    private String makeLongerList(ArrayList<String> nameList) {
        StringBuilder names = new StringBuilder();
        names.append(String.format("%s", nameList.get(0)));
        for (int i = 1; i < nameList.size() - 1; i++) {
            names.append(String.format(", %s", nameList.get(i)));
        }
        names.append(String.format(" and %s", nameList.get(nameList.size() - 1)));
        return names.toString();
    }
}