package SmallJavaProjects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static int getValidNumber(Scanner scanner) {
        int validNum = 0;

        try {
            int num = scanner.nextInt();
            scanner.nextLine();
            System.out.println("You inputted: " + num);
            validNum = num;
        } catch (Exception InputMismatchException) {
            System.out.println("You did not input a valid number");
            getValidNumber(scanner);
        }

        return validNum;
    }

    public static void main(String[] args) {
        // Creates new scanner instance
        Scanner scanner = new Scanner(System.in);

        // Prompt for first number
        System.out.println("First number: ");
        int firstNum = getValidNumber(scanner);

        // Prompt for operation
        System.out.println("What operation? +, -, /, *");
        String operationSym = scanner.nextLine();

        // Prompt for second number
        System.out.println("Second number: ");
        int secondNum = getValidNumber(scanner);

        int result = 0;
        switch (operationSym) {
            case "+":
                result = firstNum + secondNum;
                break;

            case "-":
                result = firstNum - secondNum;
                break;

            case "/":
                result = firstNum / secondNum;
                break;

            case "*":
                result = firstNum * secondNum;
                break;

            default:
                System.out.println("Operation Symbol incorrect");
        }

        System.out.println("Your result is " + result);
    }

}
