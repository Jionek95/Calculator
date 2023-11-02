import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
        StringBuilder stringBuilder = new StringBuilder();
        numbers.stream()
                .filter(num->num<0)
                .forEach(num->stringBuilder.append(num).append(" "));
        if (!stringBuilder.toString().isEmpty()){
            throw new RuntimeException("negatives are not allowed " + stringBuilder.toString());
        }
    }

    private static List<Integer> strArrayToIntList(String[] strArray) {
        return Stream.of((strArray))
                .map(Integer::parseInt)
                .toList();
    }

    private static String[] getSplit(String givenString) {
        if (givenString.startsWith("//")){
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(givenString);
            if (matcher.matches()){
                String delimiter = matcher.group(1);
                String toSplit = matcher.group(2);
                return toSplit.split(delimiter);
            }
            throw new RuntimeException("Wrong custom delimiter format");
        }
        return givenString.split(",|\n");
    }
}
