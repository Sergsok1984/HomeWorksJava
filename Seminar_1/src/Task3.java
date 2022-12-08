//3. Реализовать простой калькулятор

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double a = scanner.nextDouble();
        System.out.println("Введите операцию (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        System.out.println("Введите второе число: ");
        double b = scanner.nextDouble();
        double res = 0;
        if (b == 0 && op == '/') {
            System.out.println("Делить на 0 нельзя");
        } else {
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
            System.out.println("Решение: " + a + " " + op + " " + b + " = " + res);
            scanner.close();
        }
    }
}

