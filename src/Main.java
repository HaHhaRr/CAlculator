import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите первое число:");
        double a = sc.nextDouble();
        Operations op1 = new Operations(a);
        sc.nextLine();

        System.out.println("Введите знак операции:");
        String operation = sc.nextLine();

        switch (operation) {
            case "+/-":
                System.out.println(op1.unaryMinus());
                break;
            case "%":
                System.out.println(op1.per());
                break;
        }

        if (operation.equals("+") || operation.equals("-") || operation.equals("*") ||
                operation.equals("/") || operation.equals("^") || operation.equals("!^")) {
            System.out.println("Введите второе число:");
            double b = sc.nextDouble();
            Operations op2 = new Operations(a, b);
            switch (operation) {
                case "+":
                    System.out.println(op2.sum());
                    break;
                case "-":
                    System.out.println(op2.sub());
                    break;
                case "*":
                    System.out.println(op2.mult());
                    break;
                case "/":
                    if (op2.checkDel() == Operations.Conditions.del0) {
                        System.out.println("На ноль делить нельзя, введите другое число");
                    } else {
                        System.out.println(op2.del());
                    }
                    break;
                case "^":
                    System.out.println(op2.power());
                    break;
                case "!^":
                    if (op2.checkSqrt() == Operations.Conditions.sqrt0) {
                        System.out.println("Недопустимое число показателя корня");
                    } else {
                        System.out.println(op2.sqrt());
                    }
                    break;
            }
        }

    }
}