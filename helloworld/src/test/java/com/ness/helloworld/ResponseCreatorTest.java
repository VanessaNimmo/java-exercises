package com.ness.helloworld;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ResponseCreatorTest {

    @Test
    public void createResponseShouldReturnAStringWithNameGreetingAndTime() {
        ResponseCreator responseCreator = new ResponseCreator();

        String expected = "Hello Vanessa - the time on the server is 10:48pm on 14 March 2018";
        String result = responseCreator.createResponse(LocalDateTime.of(2018, 3, 14, 22, 48, 0, 0));

        assertEquals(expected, result);
    }

}