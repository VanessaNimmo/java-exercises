package com.ness.helloworld;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class NameListTest {

    @Test
    public void theNameVanessaIsAddedByDefault() {
        NameList nameList = new NameList();

        assertTrue(nameList.getList().contains("Vanessa"));
    }

    @Test
    public void addingANameAddsItToTheListAddsThatNameToTheList() {
        NameList nameList = new NameList();

        nameList.addToNameList("Mary");

        assertTrue(nameList.getList().contains("Mary"));

    }

    @Test
    public void theNameVanessaCannotBeRemovedFromTheList() {
        NameList nameList = new NameList();

        nameList.removeFromList("Vanessa");

        ArrayList<String> result = nameList.getList();

        assertTrue(nameList.getList().contains("Vanessa"));
    }

    @Test
    public void otherNamesCanBeRemovedFromTheList() {
        NameList nameList = new NameList();

        nameList.addToNameList("Mary");

        nameList.removeFromList("Mary");

        assertFalse(nameList.getList().contains("Mary"));
    }
}