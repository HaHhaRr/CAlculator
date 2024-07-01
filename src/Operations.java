public class Operations {

    double x;
    double y;
    double result;
    double accuracy = 1_000_000_000;


    Operations(double i) {
        x = i;
    }

    Operations(double i, double j) {
        x = i;
        y = j;
    }

    public double sum() {
        result = x + y;
        return result;
    }

    public double sub() {
        result = x - y;
        return result;
    }

    public double del() {
        if (y == 0) {
            return Double.MAX_VALUE;
        } else {
            result = x / y;
            return result;
        }
    }

    public double mult() {
        result = x * y;
        return result;

    }

    public double unaryMinus() {
        result = -x;
        return result;
    }

    public double per() {
        result = x / 100;
        return result;
    }

    private double manyMult(double i, double j) {
        double manyMult;
        if (i == 0) {
            return 1;
        }
        manyMult = manyMult(i - 1, j) * j;
        return manyMult;
    }

    public double power() {
        if (y >= 0) {
            result = manyMult(y, x);
            return result;
        } else {
            y = -y;
            x = 1 / x;
            return manyMult(y, x);
        }
    }

    public double sqrt() {
        double preDot;
        double postDot;
        boolean check = false;

        if (y == 0) {
            return Double.MAX_VALUE;
        } else if (y < 0) {
            y = -y;
            check = true;
        }

        outer:
        for (int i = 0; i < Math.sqrt(Integer.MAX_VALUE); ) {
            if (manyMult(y, i) < x) {
                i++;
                continue;
            } else if (manyMult(y, i) == x) {
                preDot = i;
            } else {
                preDot = i - 1;
            }
            for (double j = 0; j < accuracy; ) {
                postDot = j / accuracy;
                result = preDot + postDot;
                if (manyMult(y, result) < x) {
                    j++;
                } else {
                    break outer;
                }
            }
        }

        if (check) {
            return 1 / result;
        } else {
            return result;
        }
    }

    Conditions checkDel() {
        if (del() == Double.MAX_VALUE && y == 0) {
            return Conditions.del0;
        } else {
            return Conditions.correct;
        }
        //Optional
    }

    Conditions checkSqrt() {
        if (sqrt() == Double.MAX_VALUE && y == 0) {
            return Conditions.sqrt0;
        } else {
            return Conditions.correct;
        }
    }

    enum Conditions {
        correct, del0, sqrt0
    }
}
