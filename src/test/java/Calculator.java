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
        return givenString.split(",|\n");
    }
}
