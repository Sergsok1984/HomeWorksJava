public class Task2 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println("Заданная очередь: " + stack.getList());
        MyStack.enqueue(stack.value);
        System.out.println("Добавлен элемент " + "'" + stack.value + "'" + " в конец очереди: " + MyStack.list);
        System.out.println("Первый элемент " + "'" + MyStack.dequeue() + "'" + " удален из очереди: " + MyStack.list);
        System.out.println("Первый элемент " + "'" + MyStack.first() + "'" + " не удален из очереди: " + MyStack.list);
    }
}
