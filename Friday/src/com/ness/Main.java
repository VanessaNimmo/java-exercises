package com.ness;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


    }
    // Try implementing this with a placeholder for the character switch
    // Try using a stack - you can just pop it in then pop it out and it will be reversed
    public String reverse(String input) {
        String[] letters = input.split("");

        List<String> result = new ArrayList<>();

        for (int i=letters.length-1; i>=0; i--){
            result.add(letters[i]);
        }
        return String.join("", result);
    }
}
