import java.util.Scanner;

public class SystemMethods {

    static double checkInputComponent(String message, Scanner sc, boolean ifTrue, double component) {
        while (ifTrue) {
            System.out.println(message);
            if (sc.hasNextDouble()) {
                component = sc.nextDouble();
                ifTrue = !ifTrue;
            } else {
                System.out.println("Неправильный символ");
                sc.next();
            }
        }
        return component;
    }

    static void showResult(String answer, double resultOfOperation) {
        System.out.println(answer);
        System.out.println(resultOfOperation);
    }
}
