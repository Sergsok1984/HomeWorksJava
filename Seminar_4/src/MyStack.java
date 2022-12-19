import java.util.LinkedList;

public class MyStack {
    public static LinkedList<Integer> list = new LinkedList<>();
    int value = 5;

    public LinkedList<Integer> getList() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }

    public void enqueue(int value) {
        list.addLast(value);
    }

    public Integer dequeue() {
        return list.pollFirst();
    }

    public Integer first() {
        return list.getFirst();
    }
}
