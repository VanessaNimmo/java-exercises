package com.ness.helloworld;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ResponseCreator {

    public String createResponse(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mma 'on' dd LLLL yyyy");
        String formattedDateTime = time.format(formatter);
        String formattedDateTimeWithLowercase = formattedDateTime.replace("AM", "am").replace("PM","pm");
        return "Hello Vanessa - the time on the server is " + formattedDateTimeWithLowercase;
    }
}
