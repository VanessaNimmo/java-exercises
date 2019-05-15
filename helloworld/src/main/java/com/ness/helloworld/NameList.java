package com.ness.helloworld;

import java.util.ArrayList;

public class NameList {

    private final String seedName;
    private ArrayList<String> list;

    NameList(String seedName) {
        ArrayList<String> list = new ArrayList<>();
        this.seedName = seedName;
        this.list = list;
        list.add(seedName);
    }

    void addToNameList(String name) {
        list.add(name);
    }

    void removeFromList(String name) {
        if (!name.equalsIgnoreCase(this.seedName)) {
            list.remove(name);
        }
    }

    ArrayList<String> getList() {
        return list;
    }

}
