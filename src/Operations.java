public class Operations {
    static double accuracy = 1_000_000_000;

    public static double summarize(double x, double y) {
        return x + y;
    }

    public static double subtraction(double x, double y) {
        return x - y;
    }

    public static double division(double x, double y) {
        return x / y;
    }

    public static double multiplication(double x, double y) {
        return x * y;
    }

    public static double unaryMinus(double x) {
        return -x;
    }

    public static double percent(double x) {
        return x / 100;
    }

    public static double factorial(double x) {
        if (x == 0) {
            return 1;
        }
        return factorial(x - 1) * x;
    }

    private static double powerAbstract(double j, double i) {
        if (i == 0) {
            return 1;
        }
        return powerAbstract(j, i - 1) * j;
    }

    public static double power(double x, double y) {
        if (y < 0) {
            y = -y;
            x = 1 / x;
        }
        return powerAbstract(x, y);
    }

    public static double sqrt(double x, double y) {
        double result = 0;
        boolean isNegative = false;

        if (y < 0) {
            y = -y;
            isNegative = true;
        }

        outer:
        for (int i = 0; i < Math.sqrt(Integer.MAX_VALUE); ) {
            double preDot;
            if (powerAbstract(i, y) < x) {
                i++;
                continue;
            }
            if (powerAbstract(i, y) > x) {
                preDot = i - 1;
            } else {
                preDot = i;
            }
            for (double j = 0; j < accuracy; ) {
                result = preDot + j / accuracy;
                if (powerAbstract(result, y) >= x) {
                    break outer;
                }
                j++;
            }
        }

        if (isNegative) {
            return 1 / result;
        } else {
            return result;
        }
    }
}
