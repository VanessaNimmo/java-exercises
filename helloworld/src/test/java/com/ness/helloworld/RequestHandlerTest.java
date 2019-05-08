package com.ness.helloworld;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class RequestHandlerTest {

    // TODO: HTTPexchange is an abstract class so you can extend it to create a mocked version and test this class without having the server running (you can always do this unless it is final)

    @Test
    public void shouldCallGreetingFormatterWhenGetIsCalledOnRootURIAndGetGreetingBack() throws URISyntaxException, IOException {
        RequestHandler router = new RequestHandler(new GreetingFormatter(), new ResponseSender());

        HTTPExchangeStub exchange = new HTTPExchangeStub("GET", new URI("http://localhost:8080/"));

        String greeting = "Hello Vanessa - the time on the server is ";

        router.handle(exchange);


    }


}