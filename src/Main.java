import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите первое число:");
        double a = sc.nextDouble();
        sc.nextLine();
        System.out.println("Введите знак операции:");
        String operation = sc.nextLine();
        switch (operation) {
            case "+/-":
                System.out.println(Operations.unaryMinus(a));
                break;
            case "%":
                System.out.println(Operations.per(a));
                break;
            case "!":
                System.out.println(Operations.fact(a));
                break;
        }

        if (operation.equals("+") || operation.equals("-") || operation.equals("*") ||
                operation.equals("/") || operation.equals("^") || operation.equals("!^")) {
            System.out.println("Введите второе число:");
            double b = sc.nextDouble();
            switch (operation) {
                case "+":
                    System.out.println(Operations.sum(a, b));
                    break;
                case "-":
                    System.out.println(Operations.sub(a, b));
                    break;
                case "*":
                    System.out.println(Operations.mult(a, b));
                    break;
                case "/":
                    Errors.checkDel(a, b);
                    if (Errors.bool) {
                        System.out.println(Operations.del(a, b));
                    }
                    break;
                case "^":
                    System.out.println(Operations.power(a, b));
                    break;
                case "!^":
                    Errors.checkSqrt(a, b);
                    if (Errors.bool) {
                        System.out.println(Operations.sqrt(a, b));
                    }
                    break;
            }
        }
    }
}
