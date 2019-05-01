package com.ness.helloworld;

import org.junit.Test;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HelloWorldServerTest {

    @Test
    public void whenServerIsHitSuccessfullyItRespondsWithA200StatusCode() {
        get("http://localhost:8000").then().statusCode(200);
    }
}