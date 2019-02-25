package com.ness;

class Square {

    boolean isEmpty;
    char displayValue = '*';

    Square() {
        this.isEmpty = true;
    }

    void makeEntry(char entry) {
        if (isEmpty) {
            displayValue = entry;
            isEmpty = false;
        }
    }
}