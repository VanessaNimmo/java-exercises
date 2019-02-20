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
        return parseAndSum(expressionBody.split(delimiter));
    }

    private static int parseAndSum(String[] words){
        int sum = 0;
        ArrayList<Integer> negatives = new ArrayList<Integer>();
        for(int i=0; i<words.length; i++){
            int number = Integer.parseInt(words[i]);
            if(number<0){ negatives.add(number); }
            sum+=number;
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
