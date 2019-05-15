package com.ness.helloworld;

import org.junit.Test;

import static org.junit.Assert.*;

public class HttpResponseCreatorTest {

    @Test
    public void postShouldAddNameToList() {
        HttpResponseCreator handler = new HttpResponseCreator();
        NameList nameList = new NameList("Vanessa");
        String requestBody = "name=Bob";

        handler.handlePost(nameList, requestBody);

        assertTrue(nameList.getList().contains("Bob"));
    }

    @Test
    public void postShouldReturnA405ErrorResponseIfPostingAnExistingName() {
        HttpResponseCreator handler = new HttpResponseCreator();
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Bob");
        String requestBody = "name=Bob";

        HttpResponse result = handler.handlePost(nameList, requestBody);

        assertEquals(405, result.getStatusCode());

    }

    @Test
    public void putShouldRemoveOldNameFromList() {
        HttpResponseCreator handler = new HttpResponseCreator();
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Bob");
        String requestBody = "name=James";

        handler.handlePut("/names/Bob", nameList, requestBody);

        assertFalse(nameList.getList().contains("Bob"));
    }

    @Test
    public void putShouldAddNewNameToList() {
        HttpResponseCreator handler = new HttpResponseCreator();
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Bob");
        String requestBody = "name=James";

        handler.handlePut("/names/Bob", nameList, requestBody);

        assertTrue(nameList.getList().contains("James"));
    }

    @Test
    public void putShouldReturnA404ErrorIfNoNameExistsToReplace() {
        HttpResponseCreator handler = new HttpResponseCreator();
        NameList nameList = new NameList("Vanessa");
        String requestBody = "name=James";

        HttpResponse result = handler.handlePut("/names/Bob", nameList, requestBody);

        assertEquals(404, result.getStatusCode());
    }

}