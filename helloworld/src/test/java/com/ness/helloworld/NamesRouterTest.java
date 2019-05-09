package com.ness.helloworld;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class NamesRouterTest {

    // TODO: HTTPexchange is an abstract class so you can extend it to create a mocked version and test this class without having the server running (you can always do this unless it is final)

    @Test
    public void shouldCallGreetingFormatterWhenGetIsCalledOnRootURI() throws URISyntaxException, IOException {
        HTTPExchangeStub exchange = new HTTPExchangeStub("GET", new URI("http://localhost:8080/"));

        NamesRouter handler = new NamesRouter(new ResponseSender(), new NameList(), new NamesHandler());

        String greeting = "Hello Vanessa - the time on the server is ";

        handler.handle(exchange);


    }


}