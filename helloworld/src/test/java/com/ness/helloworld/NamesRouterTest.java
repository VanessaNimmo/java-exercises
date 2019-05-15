package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

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
    public void shouldRespondWith200WhenGetIsSuccessful() throws IOException, URISyntaxException {
        HttpResponseCreator handler = new HttpResponseCreator();
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Bob");
        when(mockedExchange.getRequestURI()).thenReturn(new URI("http://localhost:8080/names"));
        when(mockedExchange.getRequestMethod()).thenReturn("GET");
        NamesRouter namesRouter = new NamesRouter(new HttpResponseSender(), nameList, handler);
        ArgumentCaptor<NamesRouter> handleCaptor = ArgumentCaptor.forClass(NamesRouter.class);

        namesRouter.handle(mockedExchange);

    }

    @Test
    public void shouldRespondWith200WhenPutIsSuccessful() throws IOException, URISyntaxException {
        HttpResponseCreator mockedHttpResponseCreator = mock(HttpResponseCreator.class);
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Bob");
        when(mockedExchange.getRequestURI()).thenReturn(new URI("http://localhost:8080/names/Bob"));
        when(mockedExchange.getRequestMethod()).thenReturn("PUT");
        NamesRouter namesRouter = new NamesRouter(new HttpResponseSender(), nameList, mockedHttpResponseCreator);

        namesRouter.handle(mockedExchange);

    }


}