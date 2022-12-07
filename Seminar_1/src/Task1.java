//1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int n = scanner.nextInt();
        System.out.println("Сумма: " + getSum(n));
        System.out.println("Факториал: " + getFact(n));
    }

    private static int getSum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    private static int getFact(int n) {
        int fact = 1;
        for (int j = 1; j <= n; j++) {
                fact *= j;
            }
        return fact;
        }
}





