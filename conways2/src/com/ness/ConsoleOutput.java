package com.ness;

public class ConsoleOutput implements Output {

    @Override
    public void print(String message) {
        System.out.print(message);
    }
}