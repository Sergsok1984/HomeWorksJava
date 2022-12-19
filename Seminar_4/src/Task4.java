// Реализовать алгоритм перевода из инфиксной записи в постфиксную для арифметического выражения. 
// http://primat.org/news/obratnaja_polskaja_zapis/2016-04-09-1181 Вычислить запись если это возможно. 

import java.util.Stack;

public class Task4 {
    public static void main(String[] args) {
        String infix = "5^2/(5*1)+10";
        System.out.println("Инфиксное выражение: " + infix);
        String postfix = infixToPostfix(infix);
        System.out.println("Постфиксное выражение: " + postfix);
        System.out.println("Вычисление выражения: " + calc(postfix));
    }
    public static String infixToPostfix(String infix) {
        if (infix == null || infix.length() == 0) {
            return infix;
        }
        Stack<Character> st = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (isOperand(c)) {
                postfix.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == '^') {
                st.push('^');
                postfix.append(" ");
            } else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    postfix.append(" ").append(st.peek());
                    st.pop();
                }
                st.pop();
            } else {
                if (!st.isEmpty() && getPrec(c) > st.peek()) {
                    st.push(c);
                } else {
                    while (!st.isEmpty() && getPrec(c) >= getPrec(st.peek())) {
                        postfix.append(" ").append(st.peek());
                        st.pop();
                    }
                    postfix.append(" ");
                    st.push(c);
                }
            }
        }
        while (!st.isEmpty()) {
            postfix.append(" ").append(st.peek());
            st.pop();
        }
        return postfix.toString();
    }
    public static int getPrec(char c) {
        if (c == '^') {
            return 1;
        }
        if (c == '*' || c == '/') {
            return 2;
        }
        if (c == '+' || c == '-') {
            return 3;
        } else return 4;
    }

    public static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') ||
                (c >= '0' && c <= '9');
    }
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Float calc(String str) {
        var exp = str.split(" ");
        float res = 0;
        Stack<Float> stack = new Stack<>();
        for (String s : exp) {
            if (isDigit(s)) {
                stack.push(Float.parseFloat(s));
            } else {
                switch (s) {
                    case "+" -> {
                        res = stack.pop() + stack.pop();
                        stack.push(res);
                    }
                    case "-" -> {
                        res = -stack.pop() + stack.pop();
                        stack.push(res);
                    }
                    case "*" -> {
                        res = stack.pop() * stack.pop();
                        stack.push(res);
                    }
                    case "/" -> {
                        res = (float) Math.pow(stack.pop(), -1) * stack.pop();
                        stack.push(res);
                    }
                    case "^" -> {
                        float power = stack.pop();
                        res = (float) Math.pow(stack.pop(), power);
                        stack.push(res);
                    }
                    default -> {
                    }
                }
            }
        }
        return res;
    }
}