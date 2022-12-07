//3. Реализовать простой калькулятор

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.println("Введите операцию (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        System.out.println("Введите второе число: ");
        int b = scanner.nextInt();
        int res = 0;

        switch (op) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '/':
                res = a / b;
                break;
            case '*':
                res = a * b;
                break;
        }
        System.out.println(a + " " + op + " " + b + " = " + res);
        scanner.close();
    }
}

