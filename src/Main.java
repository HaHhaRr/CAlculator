import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String answer = "Ответ: ";
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Введите первое число:");
            double a = sc.nextDouble();

            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sc.nextLine();
                System.out.println("Введите знак операции:");
                String operation = sc.nextLine();
                double op = 0;
                switch (operation) {
                    case "+/-":
                        op = Operations.unaryMinus(a);
                        System.out.println(answer);
                        System.out.println(op);
                        break;
                    case "%":
                        op = Operations.per(a);
                        System.out.println(answer);
                        System.out.println(op);
                        break;
                    case "!":
                        op = Operations.fact(a);
                        System.out.println(answer);
                        System.out.println(op);
                        break;
                }

                if (operation.equals("+") || operation.equals("-") || operation.equals("*") ||
                        operation.equals("/") || operation.equals("^") || operation.equals("!^")) {
                    System.out.println("Введите второе число:");
                    double b = sc.nextDouble();
                    switch (operation) {
                        case "+":
                            op = Operations.sum(a, b);
                            System.out.println(answer);
                            System.out.println(op);
                            break;
                        case "-":
                            op = Operations.sub(a, b);
                            System.out.println(answer);
                            System.out.println(op);
                            break;
                        case "*":
                            op = Operations.mult(a, b);
                            System.out.println(answer);
                            System.out.println(op);
                            break;
                        case "/":
                            Errors.checkDel(a, b);
                            if (Errors.bool) {
                                op = Operations.del(a, b);
                                System.out.println(answer);
                                System.out.println(op);
                            }
                            break;
                        case "^":
                            op = Operations.power(a, b);
                            System.out.println(answer);
                            System.out.println(op);
                            break;
                        case "!^":
                            Errors.checkSqrt(a, b);
                            if (Errors.bool) {
                                op = Operations.sqrt(a, b);
                                System.out.println(answer);
                                System.out.println(op);
                            }
                            break;
                    }
                }
                a = op;
                if (operation.equals(".")) {
                    break;
                }
            }
        } catch (InputMismatchException ime) {
            System.out.println("Найден недопустимый символ");
        }
    }
}
