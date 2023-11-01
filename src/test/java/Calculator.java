import java.util.List;
import java.util.stream.Stream;

public class Calculator {
    public static int add(String givenString) {
        if (!givenString.isEmpty()) {
            List<Integer> numbers = strArrayToIntList(getSplit(givenString));
            return numbers.stream()
                    .reduce(Integer::sum)
                    .orElseThrow();
        }
        return 0;
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
