import java.util.List;
import java.util.stream.Stream;

public class Calculator {
    public static int add(String givenString) {
        if (!givenString.isEmpty()) {
            List<Integer> numbers = Stream.of(getSplit(givenString))
                    .map(Integer::parseInt)
                    .toList();
            return numbers.stream()
                    .reduce(Integer::sum)
                    .orElseThrow();
        }
        return 0;
    }

    private static String[] getSplit(String givenString) {
        return givenString.split(",|\n");
    }
}
