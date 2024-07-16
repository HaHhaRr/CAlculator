import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double firstComponent = SystemMethods.checkAndSetValueOfComponent("Введите превое число", sc);

        while (true) {
            sc.nextLine();
            System.out.println("Введите знак операции:");
            String sign = sc.nextLine();
            double resultOfOperation = 0;
            if (sign.equals("+/-") || sign.equals("%") || sign.equals("!")) {

                switch (sign) {
                    case "+/-":
                        resultOfOperation = Operations.unaryMinus(firstComponent);
                        SystemMethods.showResult(resultOfOperation);
                        break;
                    case "%":
                        resultOfOperation = Operations.percent(firstComponent);
                        SystemMethods.showResult(resultOfOperation);
                        break;
                    case "!":
                        resultOfOperation = Operations.factorial(firstComponent);
                        SystemMethods.showResult(resultOfOperation);
                        break;
                }
            } else if (sign.equals("+") || sign.equals("-") || sign.equals("*") ||
                    sign.equals("/") || sign.equals("^") || sign.equals("!^")) {

                double secondComponent = SystemMethods.checkAndSetValueOfComponent("Введите второе число:", sc);
                switch (sign) {
                    case "+":
                        resultOfOperation = Operations.summarize(firstComponent, secondComponent);
                        SystemMethods.showResult(resultOfOperation);
                        break;
                    case "-":
                        resultOfOperation = Operations.subtraction(firstComponent, secondComponent);
                        SystemMethods.showResult(resultOfOperation);
                        break;
                    case "*":
                        resultOfOperation = Operations.multiplication(firstComponent, secondComponent);
                        SystemMethods.showResult(resultOfOperation);
                        break;
                    case "/":
                        if (secondComponent == 0) {
                            System.out.println("Неправильный символ");
                            secondComponent = SystemMethods.checkAndSetValueOfComponent("Введите второе число:", sc);
                        }
                        resultOfOperation = Operations.division(firstComponent, secondComponent);
                        SystemMethods.showResult(resultOfOperation);
                        break;
                    case "^":
                        resultOfOperation = Operations.power(firstComponent, secondComponent);
                        SystemMethods.showResult(resultOfOperation);
                        break;
                    case "!^":
                        if (secondComponent == 0) {
                            System.out.println("Неправильный символ");
                            secondComponent = SystemMethods.checkAndSetValueOfComponent("Введите второе число:", sc);
                        }
                        resultOfOperation = Operations.sqrt(firstComponent, secondComponent);
                        SystemMethods.showResult(resultOfOperation);
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
