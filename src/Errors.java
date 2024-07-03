public class Errors {

    static boolean bool = true;

    static void checkDel(double x, double y) {
        if (Operations.del(x, y) == Double.MAX_VALUE && y == 0) {
            System.out.println("На ноль делить нельзя, введите другое число");
            bool = false;
        }
    }

    static void checkSqrt(double x, double y) {
        if (Operations.sqrt(x, y) == Double.MAX_VALUE && y == 0) {
            System.out.println("Недопустимое число показателя корня");
            bool = false;
        }
    }
}
