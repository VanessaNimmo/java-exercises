package com.ness.helloworld;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.Assert.*;

public class GreetingFormatterTest {

    @Test
    public void whenGivenAndEmptyNameListCreateResponseShouldReturnAStringWithNameGreetingAndTime() {
        GreetingFormatter greetingFormatter = new GreetingFormatter();

        String expected = "Hello Vanessa - the time on the server is 10:48pm on 14 March 2018";
        NameList nameList = new NameList("Vanessa");
        ZoneId zoneId = ZoneId.of("Australia/Melbourne");
        String result = greetingFormatter.createFormattedGreeting(ZonedDateTime.of(2018, 3, 14, 22, 48, 0, 0, zoneId), nameList);

        assertEquals(expected, result);
    }

    @Test
    public void whenGivenOneNameInAListCreateResponseShouldReturnAGreetingWithThatName() {
        GreetingFormatter greetingFormatter = new GreetingFormatter();

        String expected = "Hello Vanessa and Bob - the time on the server is 10:48pm on 14 March 2018";
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Bob");
        ZoneId zoneId = ZoneId.of("Australia/Melbourne");
        String result = greetingFormatter.createFormattedGreeting(ZonedDateTime.of(2018, 3, 14, 22, 48, 0, 0, zoneId), nameList);

        assertEquals(expected, result);
    }

    @Test
    public void whenGivenTwoNamesResponseReturnsGreetingWithAllNames() {
        GreetingFormatter greetingFormatter = new GreetingFormatter();

        String expected = "Hello Vanessa, Bob and Mary - the time on the server is 10:48pm on 14 March 2018";
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Bob");
        nameList.addToNameList("Mary");
        ZoneId zoneId = ZoneId.of("Australia/Melbourne");
        String result = greetingFormatter.createFormattedGreeting(ZonedDateTime.of(2018, 3, 14, 22, 48, 0, 0, zoneId), nameList);

        assertEquals(expected, result);
    }

    @Test
    public void whenGivenThreeNamesResponseReturnsGreetingWithAllNames() {
        GreetingFormatter greetingFormatter = new GreetingFormatter();

        String expected = "Hello Vanessa, Bob, Mary and Mohamad - the time on the server is 10:48pm on 14 March 2018";
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Bob");
        nameList.addToNameList("Mary");
        nameList.addToNameList("Mohamad");
        ZoneId zoneId = ZoneId.of("Australia/Melbourne");
        String result = greetingFormatter.createFormattedGreeting(ZonedDateTime.of(2018, 3, 14, 22, 48, 0, 0, zoneId), nameList);

        assertEquals(expected, result);
    }

    @Test
    public void whenGivenMoreThanThreeNamesResponseReturnsGreetingWithAllNames() {
        GreetingFormatter greetingFormatter = new GreetingFormatter();

        String expected = "Hello Vanessa, Bob, Mary, Mohamad and Preethi - the time on the server is 10:48pm on 14 March 2018";
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Bob");
        nameList.addToNameList("Mary");
        nameList.addToNameList("Mohamad");
        nameList.addToNameList("Preethi");
        ZoneId zoneId = ZoneId.of("Australia/Melbourne");
        String result = greetingFormatter.createFormattedGreeting(ZonedDateTime.of(2018, 3, 14, 22, 48, 0, 0, zoneId), nameList);

        assertEquals(expected, result);
    }
}