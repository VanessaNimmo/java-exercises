package com.ness.helloworld;

import java.util.ArrayList;

public class NameList {

    public ArrayList<String> getList() {
        return list;
    }

    private ArrayList<String> list;

    NameList() {
        ArrayList<String> list = new ArrayList<>();
        this.list = list;
    }

    void addToNameList(String name) {
        list.add(name);
    }
}
