package com.ness;

import java.util.ArrayList;

public class StringCalculator {

    public static int add(String expression){
        if (expression == ""){
            return 0;
        }
        String delimiter = ",|\n";
        String expressionBody = expression;
        if (hasHeader(expression)){
            delimiter = Character.toString(expression.charAt(2));
            String[] lines = expression.split("\n");
            expressionBody = lines[1];
        }
        ArrayList<Integer> expressionToSum = getNumbers(expressionBody, delimiter);
//        checkforNegatives(expressionToSum);
        return sumNumbersBelow1000(expressionToSum);
    }

    private static ArrayList<Integer> getNumbers(String expressionBody, String delimiter) {
        String[] numbersAsStrings = expressionBody.split(delimiter);
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int i=0; i<numbersAsStrings.length; i++){
            numbers.add(Integer.parseInt(numbersAsStrings[i]));
        }
        return numbers;
    }

    private static int sumNumbersBelow1000(ArrayList<Integer> numbers){
        int sum = 0;
        ArrayList<Integer> negatives = new ArrayList<Integer>();
        for(Integer num:numbers){
            if(num<0) negatives.add(num);
            if(num<1000) sum += num;
        }
        if(!negatives.isEmpty()) {
            String negativesForError = "";
            negativesForError += Integer.toString(negatives.get(0));
            for(int i=1; i<negatives.size(); i++) { negativesForError += (", " + Integer.toString(negatives.get(i))); }
            String errorMessage = "Negatives not allowed: " + negativesForError;
            throw new RuntimeException(errorMessage);
        }
        return sum;
    }

    private static boolean hasHeader(String word){
        return word.startsWith("//");
    }

}
