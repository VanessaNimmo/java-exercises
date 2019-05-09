package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class NamesRouterTest {

    // This is horrible to test - how do I get away from the HttpExchange???
    @Test
    public void shouldCallNamesRouterPutClassWhenRequestIsAPut() throws IOException, URISyntaxException {
        NamesHandler mockedNamesHandler = mock(NamesHandler.class);
        HttpExchange mockedExchange = mock(HttpExchange.class);
        NameList nameList = new NameList();
        nameList.addToNameList("Bob");
        when(mockedExchange.getRequestURI()).thenReturn(new URI("http://localhost:8080/names/Bob"));
        when(mockedExchange.getRequestMethod()).thenReturn("PUT");
        when(mockedNamesHandler.handlePut("/names/Bob", mockedExchange, nameList)).thenReturn("James");
        NamesRouter namesRouter = new NamesRouter(new HttpResponseSender(), new NameList(), mockedNamesHandler);

        namesRouter.handle(mockedExchange);

    }


}