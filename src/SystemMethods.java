import java.util.Scanner;

public class SystemMethods {

    static double checkAndSetValueOfComponent(String message, Scanner sc) {
        double component;
        while (true) {
            System.out.println(message);
            if (sc.hasNextDouble()) {
                component = sc.nextDouble();
                break;
            } else {
                System.out.println("Неправильный символ");
                sc.next();
            }
        }
        return component;
    }

    static void showResult(double resultOfOperation) {
        System.out.println("Ответ:");
        System.out.println(resultOfOperation);
    }
}
