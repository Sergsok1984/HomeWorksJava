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

    public LinkedList<Integer> enqueue(int value) {
        list.addLast(value);
        return list;
    }

    public Integer dequeue(LinkedList<Integer> list) {
        return list.pollFirst();
    }

    public Integer first(LinkedList<Integer> list) {
        return list.getFirst();
    }
}
