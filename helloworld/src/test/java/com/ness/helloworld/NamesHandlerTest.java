package com.ness.helloworld;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NamesHandlerTest {

    @Test
    public void postShouldAddNameToList() {
        NamesHandler handler = new NamesHandler();
        NameList nameList = new NameList("Vanessa");
        String requestBody = "name=Bob";

        handler.handlePost(nameList, requestBody);

        assertTrue(nameList.getList().contains("Bob"));
    }

    @Test
    public void postShouldRefuseToAddNameIfNameAlreadyInList() {
        // Not sure how I want it to behave in this case!
        // TODO: Work out what behaviour you want here
    }

    @Test
    public void putShouldRemoveOldNameFromList() {
        NamesHandler handler = new NamesHandler();
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Bob");
        String requestBody = "name=James";

        handler.handlePut("/names/Bob", nameList, requestBody);

        assertFalse(nameList.getList().contains("Bob"));
    }

    @Test
    public void putShouldAddNewNameToList() {
        NamesHandler handler = new NamesHandler();
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Bob");
        String requestBody = "name=James";

        handler.handlePut("/names/Bob", nameList, requestBody);

        assertTrue(nameList.getList().contains("James"));
    }

}