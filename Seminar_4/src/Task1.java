//Пусть дан LinkedList с несколькими элементами.
//Реализуйте метод, который вернет “перевернутый” список.

import java.util.LinkedList;

public class Task1 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        System.out.println("Заданный список: " + list);
        System.out.println("Перевёрнутый список: " + reversLinkedList(list));
    }

    public static LinkedList<Integer> reversLinkedList(LinkedList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            list.add(i, list.pollLast());
        }
        return list;
    }
}


