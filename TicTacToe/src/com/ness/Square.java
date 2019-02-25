package com.ness;

public class Square {

    public boolean isEmpty;
    public char displayValue = '.';

    public Square() {
        this.isEmpty = true;
    }

    public void makeEntry(char entry) {
        if (isEmpty) {
            displayValue = entry;
            isEmpty = false;
        }
    }
}