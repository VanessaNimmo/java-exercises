package com.ness.helloworld;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class HelloWorldServerTest {

    @Test
    public void whenServerIsHitSuccessfullyItRespondsWithA200StatusCode() {
        get("http://localhost:8080").then().statusCode(200);
    }

    @Test
    public void whenServerIsHitSuccessfullyTheResponseContainsNameAndGreeting() {
        get("http://localhost:8080").then().body(containsString("Hello Vanessa - the time on the server is "));
    }
}