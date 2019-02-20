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
            delimiter = getDelimiter(expression);
            String[] lines = expression.split("\n");
            expressionBody = lines[1];
        }
        ArrayList<Integer> expressionToSum = getNumbers(expressionBody, delimiter);
        checkforNegatives(expressionToSum);
        return sumNumbersBelow1000(expressionToSum);
    }

    private static void checkforNegatives(ArrayList<Integer> expressionToSum) {
        ArrayList<Integer> negatives = new ArrayList<Integer>();
        for(Integer num:expressionToSum){
            if(num<0) negatives.add(num);
        }
        if(!negatives.isEmpty()) {
            String negativesForError = "";
            negativesForError += Integer.toString(negatives.get(0));
            for(int i=1; i<negatives.size(); i++) { negativesForError += (", " + Integer.toString(negatives.get(i))); }
            String errorMessage = "Negatives not allowed: " + negativesForError;
            throw new RuntimeException(errorMessage);
        }
    }

    private static String getDelimiter(String expression) {
        if(!expression.contains("[")) {
            return Character.toString(expression.charAt(2));
        }
        int startIndex = expression.indexOf("[") + 1;
        int endIndex = expression.indexOf("]");
        String delim = expression.substring(startIndex, endIndex);
        if (delim.contains("*")) {
            // Insert escape characters before each one
            StringBuilder str = new StringBuilder();
            for(int i=0; i<delim.length(); i++){
                if(delim.charAt(i)=='*'){
                   str.append('\\');
                }
                str.append(delim.charAt(i));
            }
            delim = str.toString();
        }
        return delim;
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
        for(Integer num:numbers){
            if(num<1000) sum += num;
        }
        return sum;
    }

    private static boolean hasHeader(String word){
        return word.startsWith("//");
    }

}
