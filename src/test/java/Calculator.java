public class Calculator {
    public static int add(String s) {
        if (!s.isEmpty()) {
            return Integer.parseInt(s);
        }
        return 0;
    }
}
