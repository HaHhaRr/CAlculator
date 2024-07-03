public class Operations {
    static double accuracy = 1_000_000_000;

    public static double sum(double x, double y) {
        return x + y;
    }

    public static double sub(double x, double y) {
        return x - y;
    }

    public static double del(double x, double y) {
        if (y == 0) {
            return Double.MAX_VALUE;
        }
        return x / y;
    }

    public static double mult(double x, double y) {
        return x * y;

    }

    public static double unaryMinus(double x) {
        return -x;
    }

    public static double per(double x) {
        return x / 100;
    }

    public static double fact(double x) {
        if (x == 0) {
            return 1;
        }
        return fact(x - 1) * x;
    }

    private static double powerMeth(double j, double i) {
        if (i == 0) {
            return 1;
        }
        return powerMeth(j, i - 1) * j;
    }

    public static double power(double x, double y) {
        if (y < 0) {
            y = -y;
            x = 1 / x;
        }
        return powerMeth(x, y);
    }

    public static double sqrt(double x, double y) {
        double res = 0;
        boolean check = false;

        if (y == 0) {
            return Double.MAX_VALUE;
        } else if (y < 0) {
            y = -y;
            check = true;
        }

        outer:
        for (int i = 0; i < Math.sqrt(Integer.MAX_VALUE); ) {
            double preDot;
            if (powerMeth(i, y) < x) {
                i++;
                continue;
            }
            if (powerMeth(i, y) > x) {
                preDot = i - 1;
            } else {
                preDot = i;
            }
            for (double j = 0; j < accuracy; ) {
                res = preDot + j / accuracy;
                if (powerMeth(res, y) >= x) {
                    break outer;
                }
                j++;
            }
        }

        if (check) {
            return 1 / res;
        } else {
            return res;
        }
    }

}
