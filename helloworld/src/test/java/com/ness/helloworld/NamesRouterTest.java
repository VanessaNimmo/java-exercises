package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class NamesRouterTest {

    private HttpExchange mockedExchange;
    private HttpResponseSender mockedSender;
    private NameList nameList;
    private HttpResponseCreator responseCreator;
    private ArgumentCaptor<HttpResponse> handleCaptor;


    @Before
    public void setUp() {
        mockedExchange = mock(HttpExchange.class);
        mockedSender = mock(HttpResponseSender.class);
        nameList = new NameList("Vanessa");
        responseCreator = new HttpResponseCreator();
        handleCaptor = ArgumentCaptor.forClass(HttpResponse.class);

    }

    @Test
    public void shouldRespondWith200WhenGetIsSuccessful() throws IOException, URISyntaxException {
        when(mockedExchange.getRequestURI()).thenReturn(new URI("http://localhost:8080/names"));
        when(mockedExchange.getRequestMethod()).thenReturn("GET");
        NamesRouter namesRouter = new NamesRouter(nameList, responseCreator, mockedSender);
        ArgumentCaptor<HttpResponse> handleCaptor = ArgumentCaptor.forClass(HttpResponse.class);

        namesRouter.handle(mockedExchange);

        verify(mockedSender).send(handleCaptor.capture(), eq(mockedExchange));
        assertEquals(200, handleCaptor.getValue().getStatusCode());
    }

    @Test
    public void shouldRespondWith201WhenPostIsSuccessful() throws IOException, URISyntaxException {
        NameList nameList = new NameList("Vanessa");
        when(mockedExchange.getRequestURI()).thenReturn(new URI("http://localhost:8080/names"));
        when(mockedExchange.getRequestMethod()).thenReturn("POST");
        InputStream requestBodyContent = new ByteArrayInputStream("name=Bob".getBytes());
        when(mockedExchange.getRequestBody()).thenReturn(requestBodyContent);
        NamesRouter namesRouter = new NamesRouter(nameList, responseCreator, mockedSender);

        namesRouter.handle(mockedExchange);

        verify(mockedSender).send(handleCaptor.capture(), eq(mockedExchange));
        assertEquals(201, handleCaptor.getValue().getStatusCode());
    }


    @Test
    public void shouldRespondWith201WhenPutIsSuccessful() throws IOException, URISyntaxException {
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Bob");
        when(mockedExchange.getRequestURI()).thenReturn(new URI("http://localhost:8080/names/Bob"));
        when(mockedExchange.getRequestMethod()).thenReturn("PUT");
        InputStream requestBodyContent = new ByteArrayInputStream("name=James".getBytes());
        when(mockedExchange.getRequestBody()).thenReturn(requestBodyContent);
        NamesRouter namesRouter = new NamesRouter(nameList, responseCreator, mockedSender);

        namesRouter.handle(mockedExchange);

        verify(mockedSender).send(handleCaptor.capture(), eq(mockedExchange));
        assertEquals(201, handleCaptor.getValue().getStatusCode());
    }

    @Test
    public void shouldRespondWith200WhenDeleteIsSuccessful() throws IOException, URISyntaxException {
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Bob");
        when(mockedExchange.getRequestURI()).thenReturn(new URI("http://localhost:8080/names/Bob"));
        when(mockedExchange.getRequestMethod()).thenReturn("DELETE");
        NamesRouter namesRouter = new NamesRouter(nameList, responseCreator, mockedSender);

        namesRouter.handle(mockedExchange);

        verify(mockedSender).send(handleCaptor.capture(), eq(mockedExchange));
        assertEquals(200, handleCaptor.getValue().getStatusCode());
    }

    @Test
    public void shouldRespondWith501WhenRequestIsNotImplemented() throws IOException, URISyntaxException {
        NameList nameList = new NameList("Vanessa");
        when(mockedExchange.getRequestURI()).thenReturn(new URI("http://localhost:8080/names"));
        when(mockedExchange.getRequestMethod()).thenReturn("PATCH");
        NamesRouter namesRouter = new NamesRouter(nameList, responseCreator, mockedSender);
        InputStream requestBodyContent = new ByteArrayInputStream("name=James".getBytes());
        when(mockedExchange.getRequestBody()).thenReturn(requestBodyContent);

        namesRouter.handle(mockedExchange);

        verify(mockedSender).send(handleCaptor.capture(), eq(mockedExchange));
        assertEquals(501, handleCaptor.getValue().getStatusCode());
    }

    @Test
    public void shouldRespondWith500WhenRequestCausesAnError() throws IOException, URISyntaxException {
        NameList nameList = new NameList("Vanessa");
        when(mockedExchange.getRequestURI()).thenReturn(new URI("http://localhost:8080/names"));
        when(mockedExchange.getRequestMethod()).thenReturn("POST");
        NamesRouter namesRouter = new NamesRouter(nameList, responseCreator, mockedSender);

        namesRouter.handle(mockedExchange);

        verify(mockedSender).send(handleCaptor.capture(), eq(mockedExchange));
        assertEquals(500, handleCaptor.getValue().getStatusCode());
    }

    @Test
    public void shouldRespondWith404WhenPutIsCalledOnANameNotPresentInList() throws IOException, URISyntaxException {
        NameList nameList = new NameList("Vanessa");
        when(mockedExchange.getRequestURI()).thenReturn(new URI("http://localhost:8080/names/Bob"));
        when(mockedExchange.getRequestMethod()).thenReturn("PUT");
        InputStream requestBodyContent = new ByteArrayInputStream("name=James".getBytes());
        when(mockedExchange.getRequestBody()).thenReturn(requestBodyContent);
        NamesRouter namesRouter = new NamesRouter(nameList, responseCreator, mockedSender);

        namesRouter.handle(mockedExchange);

        verify(mockedSender).send(handleCaptor.capture(), eq(mockedExchange));
        assertEquals(404, handleCaptor.getValue().getStatusCode());
    }

    @Test
    public void shouldRespondWith405WhenDeleteIsCalledOnSeedName() throws IOException, URISyntaxException {
        NameList nameList = new NameList("Vanessa");
        when(mockedExchange.getRequestURI()).thenReturn(new URI("http://localhost:8080/names/Vanessa"));
        when(mockedExchange.getRequestMethod()).thenReturn("DELETE");
        NamesRouter namesRouter = new NamesRouter(nameList, responseCreator, mockedSender);

        namesRouter.handle(mockedExchange);

        verify(mockedSender).send(handleCaptor.capture(), eq(mockedExchange));
        assertEquals(405, handleCaptor.getValue().getStatusCode());
    }
}