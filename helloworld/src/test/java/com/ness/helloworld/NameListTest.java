package com.ness.helloworld;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NameListTest {

    @Test
    public void theNameVanessaIsAddedByDefault() {
        NameList nameList = new NameList("Vanessa");

        ArrayList<String> result = nameList.getList();

        assertTrue(result.contains("Vanessa"));
    }

    @Test
    public void addingANameAddsItToTheListAddsThatNameToTheList() {
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Mary");

        ArrayList<String> result = nameList.getList();

        assertTrue(result.contains("Mary"));

    }

    @Test
    public void theNameVanessaCannotBeRemovedFromTheList() {
        NameList nameList = new NameList("Vanessa");
        nameList.removeFromList("Vanessa");

        ArrayList<String> result = nameList.getList();

        assertTrue(result.contains("Vanessa"));
    }

    @Test
    public void otherNamesCanBeRemovedFromTheList() {
        NameList nameList = new NameList("Vanessa");
        nameList.addToNameList("Mary");
        nameList.removeFromList("Mary");

        ArrayList<String> result = nameList.getList();

        assertFalse(result.contains("Mary"));
    }
}