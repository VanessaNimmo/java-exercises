package com.ness.helloworld;

import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class NamesHandlerTest {

    @Test
    public void putShouldChangeNameInNameList() throws URISyntaxException {
        NamesHandler handler = new NamesHandler();
        NameList nameList = new NameList();
        nameList.addToNameList("Bob");
        HTTPExchangeStub exchange = new HTTPExchangeStub("PUT", new URI("http://localhost:8080/"));

        handler.handlePut("/names/Bob", exchange, nameList);


    }

}