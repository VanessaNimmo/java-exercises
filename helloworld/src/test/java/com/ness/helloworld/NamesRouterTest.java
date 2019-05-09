package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.mockito.Mockito.*;

public class NamesRouterTest {

    private HttpExchange mockedExchange;
    @Before
    public void setUp() {
        HttpExchange mockedExchange = mock(HttpExchange.class);
    }
    // TODO: use ArgumentCaptor to capture what is send by the Response Sender in order to test the NameRouter
    @Test
    public void shouldCallNamesRouterPutClassWhenRequestIsAPut() throws IOException, URISyntaxException {
        NamesHandler mockedNamesHandler = mock(NamesHandler.class);
        NameList nameList = new NameList();
        nameList.addToNameList("Bob");
        when(mockedExchange.getRequestURI()).thenReturn(new URI("http://localhost:8080/names/Bob"));
        when(mockedExchange.getRequestMethod()).thenReturn("PUT");
        NamesRouter namesRouter = new NamesRouter(new HttpResponseSender(), new NameList(), mockedNamesHandler);

        namesRouter.handle(mockedExchange);

    }


}