import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String answer = "Ответ: ";
        Scanner sc = new Scanner(System.in);
        double firstComponent = 0;
        boolean firstIsDouble = true;
        boolean secondIsDouble = true;

        firstComponent = SystemMethods.checkInputComponent("Введите первое число:", sc, firstIsDouble, firstComponent);

        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            sc.nextLine();
            System.out.println("Введите знак операции:");
            String sign = sc.nextLine();
            double resultOfOperation = 0;

            if (sign.equals("+/-") || sign.equals("%") || sign.equals("!")) {
                switch (sign) {
                    case "+/-":
                        resultOfOperation = Operations.unaryMinus(firstComponent);
                        SystemMethods.showResult(answer, resultOfOperation);
                        break;
                    case "%":
                        resultOfOperation = Operations.per(firstComponent);
                        SystemMethods.showResult(answer, resultOfOperation);
                        break;
                    case "!":
                        resultOfOperation = Operations.fact(firstComponent);
                        SystemMethods.showResult(answer, resultOfOperation);
                        break;
                }
            } else if (sign.equals("+") || sign.equals("-") || sign.equals("*") ||
                    sign.equals("/") || sign.equals("^") || sign.equals("!^")) {

                double secondComponent = 0;
                secondComponent = SystemMethods.checkInputComponent("Введите второе число:", sc, secondIsDouble, secondComponent);

                switch (sign) {
                    case "+":
                        resultOfOperation = Operations.sum(firstComponent, secondComponent);
                        SystemMethods.showResult(answer, resultOfOperation);
                        break;
                    case "-":
                        resultOfOperation = Operations.sub(firstComponent, secondComponent);
                        SystemMethods.showResult(answer, resultOfOperation);
                        break;
                    case "*":
                        resultOfOperation = Operations.mult(firstComponent, secondComponent);
                        SystemMethods.showResult(answer, resultOfOperation);
                        break;
                    case "/":
                        if (secondComponent == 0) {
                            System.out.println("Неправильный символ");
                            secondComponent = SystemMethods.checkInputComponent("Введите второе число:", sc, secondIsDouble, secondComponent);
                        }
                        resultOfOperation = Operations.del(firstComponent, secondComponent);
                        SystemMethods.showResult(answer, resultOfOperation);
                        break;
                    case "^":
                        resultOfOperation = Operations.power(firstComponent, secondComponent);
                        SystemMethods.showResult(answer, resultOfOperation);
                        break;
                    case "!^":
                        if (secondComponent == 0) {
                            System.out.println("Неправильный символ");
                            secondComponent = SystemMethods.checkInputComponent("Введите второе число:", sc, secondIsDouble, secondComponent);
                        }
                        resultOfOperation = Operations.sqrt(firstComponent, secondComponent);
                        SystemMethods.showResult(answer, resultOfOperation);
                        break;
                }
            } else if (sign.equals(".")) {
                break;
            } else {
                System.out.println("Неправильный символ");
                continue;
            }

            firstComponent = resultOfOperation;
        }
    }
}
