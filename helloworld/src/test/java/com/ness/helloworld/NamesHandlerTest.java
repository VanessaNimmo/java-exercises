package com.ness.helloworld;

import com.sun.net.httpserver.HttpExchange;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class NamesHandlerTest {

    @Test
    public void postShouldAddNameToList() {

    }

    @Test
    public void postShouldRefuseToAddNameIfNameAlreadyInList() {

    }

    @Test
    public void putShouldRemoveOldNameFromList() {
        NamesHandler handler = new NamesHandler();
        NameList nameList = new NameList();
        nameList.addToNameList("Bob");
        HttpExchange mockedExchange = mock(HttpExchange.class);
        String requestBodyContent = "name=James";
        InputStream requestBodyStream = new ByteArrayInputStream(requestBodyContent.getBytes());
        when(mockedExchange.getRequestBody()).thenReturn(requestBodyStream);

        handler.handlePut("/names/Bob", mockedExchange, nameList);

        assertFalse(nameList.getList().contains("Bob"));
    }

    @Test
    public void putShouldAddNewNameToList() {
        NamesHandler handler = new NamesHandler();
        NameList nameList = new NameList();
        nameList.addToNameList("Bob");
        HttpExchange mockedExchange = mock(HttpExchange.class);
        String requestBodyContent = "name=James";
        InputStream requestBodyStream = new ByteArrayInputStream(requestBodyContent.getBytes());
        when(mockedExchange.getRequestBody()).thenReturn(requestBodyStream);

        handler.handlePut("/names/Bob", mockedExchange, nameList);

        assertTrue(nameList.getList().contains("James"));
    }

}