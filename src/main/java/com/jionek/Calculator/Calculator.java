package com.jionek.Calculator;

import java.util.List;
import java.util.stream.Stream;

public class Calculator {
    public static int add(String givenString) {
        if (!givenString.isEmpty()) {
            List<Integer> numbers = strArrayToIntList(getSplit(givenString));
            negatives(numbers);
            return numbers.stream()
                    .reduce(Integer::sum)
                    .orElseThrow();
        }
        return 0;
    }

    private static void negatives(List<Integer> numbers) {
        StringBuilder stringFromNegative = new StringBuilder();
        numbers.stream()
                .filter(num->num<0)
                .forEach(num->stringFromNegative.append(num).append(" "));
        if (!stringFromNegative.isEmpty()){
            throw new RuntimeException("negatives are not allowed " + stringFromNegative);
        }
    }

    private static List<Integer> strArrayToIntList(String[] strArray) {
        return Stream.of((strArray))
                .map(Integer::parseInt)
                .toList();
    }

    private static String[] getSplit(String givenString) {
        if (givenString.startsWith("//")){
            String[] parts = givenString.split("//;\n");
            return parts[1].split(";");

//            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(givenString);
//            if (matcher.matches()){
//                String delimiter = matcher.group(1);
//                String toSplit = matcher.group(2);
//                return toSplit.split(delimiter);
        }
        return givenString.split(",|\n");
    }
}
