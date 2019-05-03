package com.ness.helloworld;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ResponseCreatorTest {

    @Test
    public void whenGivenAndEmptyNameListCreateResponseShouldReturnAStringWithNameGreetingAndTime() {
        ResponseCreator responseCreator = new ResponseCreator();

        String expected = "Hello Vanessa - the time on the server is 10:48pm on 14 March 2018";
        NameList nameList = new NameList();
        String result = responseCreator.createResponse(LocalDateTime.of(2018, 3, 14, 22, 48, 0, 0), nameList);

        assertEquals(expected, result);
    }

    @Test
    public void whenGivenOneNameInAListCreateResponseShouldReturnAGreetingWithThatName() {
        ResponseCreator responseCreator = new ResponseCreator();

        String expected = "Hello Vanessa and Bob - the time on the server is 10:48pm on 14 March 2018";
        NameList nameList = new NameList();
        nameList.addToNameList("Bob");
        String result = responseCreator.createResponse(LocalDateTime.of(2018, 3, 14, 22, 48, 0, 0), nameList);

        assertEquals(expected, result);
    }

    @Test
    public void whenGivenTwoNamesResponseReturnsGreetingWithAllNames() {
        ResponseCreator responseCreator = new ResponseCreator();

        String expected = "Hello Vanessa, Bob and Mary - the time on the server is 10:48pm on 14 March 2018";
        NameList nameList = new NameList();
        nameList.addToNameList("Bob");
        nameList.addToNameList("Mary");
        String result = responseCreator.createResponse(LocalDateTime.of(2018, 3, 14, 22, 48, 0, 0), nameList);

        assertEquals(expected, result);
    }

    @Test
    public void whenGivenThreeNamesResponseReturnsGreetingWithAllNames() {
        ResponseCreator responseCreator = new ResponseCreator();

        String expected = "Hello Vanessa, Bob, Mary and Mohamad - the time on the server is 10:48pm on 14 March 2018";
        NameList nameList = new NameList();
        nameList.addToNameList("Bob");
        nameList.addToNameList("Mary");
        nameList.addToNameList("Mohamad");
        String result = responseCreator.createResponse(LocalDateTime.of(2018, 3, 14, 22, 48, 0, 0), nameList);

        assertEquals(expected, result);
    }

}