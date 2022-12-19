public class Task2 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println("Заданная очередь: " + stack.getList());
        stack.enqueue(stack.value);
        System.out.println("Добавлен элемент " + "'" + stack.value + "'" + " в конец очереди: " + MyStack.list);
        System.out.println("Первый элемент " + "'" + stack.dequeue() + "'" + " удален из очереди: " + MyStack.list);
        System.out.println("Первый элемент " + "'" + stack.first() + "'" + " не удален из очереди: " + MyStack.list);
    }
}
