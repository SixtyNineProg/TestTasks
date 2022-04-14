public class Function {
    public static double calculateValue(int n) {
        if (n > 1) {
            int mul = 0;
            for (int i = 1; i <= n; i++) {
                mul += getFactorial(i);
            }
            return ((double) 1 / getFactorial(n)) * mul;
        } else {
            System.out.println("N less then 2");
            return 0;
        }
    }

    private static long getFactorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * getFactorial(n - 1);
    }
}
