import java.util.LinkedList;

public class MyStack {
    static LinkedList<Integer> list = new LinkedList<>();
    int value = 5;

    public LinkedList<Integer> getList() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }

    public static void enqueue(int value) {
        list.addLast(value);
    }

    public static Integer dequeue() {
        return list.pollFirst();
    }

    public static Integer first() {
        return list.getFirst();
    }
}
