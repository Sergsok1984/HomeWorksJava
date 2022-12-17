import java.util.Scanner;
import java.util.Stack;

public class Task3 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        System.out.print("Введите первое число: \n");
        st.push(scanner.nextInt());
        char op = operation();
        System.out.print("Введите второе число: \n");
        st.push(scanner.nextInt());
        calc(st, op);
        while (true) {
            System.out.println("Отменить последнюю операцию?\nДа - 'y';\nНет - 'n'");
            op = scanner.next().charAt(0);
            if (op == 'y') {
                System.out.println("Первое число: " + st.peek());
                op = operation();
                System.out.print("Введите второе число: ");
                st.push(scanner.nextInt());
                calc(st, op);
                continue;
            }
            if (op == 'n') {
                System.out.println("Программа завершена!");
                break;
            }
        }
    }

    public static char operation() {
        System.out.println("Введите операцию (+, -, *, /): ");
        char op = scanner.next().charAt(0);
        if (op == '+' || op == '-' || op == '*' || op == '/') {
            return op;
        } else {
            throw new IllegalArgumentException("Некорректная операция!");
        }
    }

    public static void calc(Stack<Integer> st, Character op) {
        double b = st.pop();
        double a = st.peek();
        double res = 0;
        if (b == 0 && op == '/') {
            System.out.println("Делить на 0 нельзя");
        } else {
            switch (op) {
                case '+' -> res = a + b;
                case '-' -> res = a - b;
                case '*' -> res = a * b;
                case '/' -> res = a / b;
            }
            System.out.println("Решение: " + a + " " + op + " " + b + " = " + res);
        }
    }
}
