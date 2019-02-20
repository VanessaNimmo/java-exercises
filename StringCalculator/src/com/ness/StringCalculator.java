package com.ness;

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
        for(int i=0; i<words.length; i++){
            int number = Integer.parseInt(words[i]);
            sum+=number;
        }
        return sum;
    }

    private static boolean hasHeader(String word){
        return word.startsWith("//");
    }

}
