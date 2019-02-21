package com.ness;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

    public static int add(String expression){
        if (expression.isEmpty()){
            return 0;
        }
        String delimiter = ",|\n";
        String expressionBody = expression;
        if (hasHeader(expression)){
            String[] lines = expression.split("\n");
            delimiter = getDelimiter(lines[0]);
            expressionBody = lines[1];
        }
        int[] expressionToSum = getNumbers(expressionBody, delimiter);
        checkforNegatives(expressionToSum);
        return sumNumbersBelow1000(expressionToSum);
    }

    private static void checkforNegatives(int[] expressionToSum) {
        int[] negatives = Arrays.stream(expressionToSum).filter(num -> num < 0).toArray();
        if(negatives.length>0) {
            String negativesForError = Arrays.stream(negatives).mapToObj(String::valueOf).collect(Collectors.joining(", "));
            String errorMessage = "Negatives not allowed: " + negativesForError;
            throw new RuntimeException(errorMessage);
        }
    }

    private static String getDelimiter(String header) {
        if(!header.contains("[")) {
            return Character.toString(header.charAt(2));
        }
        String cleanHeader = header.substring(3, header.length()-1);
        String[] delims = cleanHeader.split(Pattern.quote("]["));
        return Arrays.stream(delims).map(Pattern::quote).collect(Collectors.joining("|"));
    }

    private static int[] getNumbers(String expressionBody, String delimiter) {
        String[] numbersAsStrings = expressionBody.split(delimiter);
        return Arrays.stream(numbersAsStrings).mapToInt(Integer::parseInt).toArray();
    }

    private static int sumNumbersBelow1000(int[] numbers){
        return Arrays.stream(numbers).filter(num -> num < 1000).sum();
    }

    private static boolean hasHeader(String word){
        return word.startsWith("//");
    }

}