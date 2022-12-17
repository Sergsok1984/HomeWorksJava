public class Task2 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println("Заданная очередь: " + stack.getList());
        System.out.println("Добавлен элемент " + stack.value + " в конец очереди: " + stack.enqueue(stack.value));
        System.out.println("Первый элемент " + stack.dequeue(MyStack.list) + " удален из очереди: " + MyStack.list);
        System.out.println("Первый элемент " + stack.first(MyStack.list) + " не удален из очереди: " + MyStack.list);
    }
}
