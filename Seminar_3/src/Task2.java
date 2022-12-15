//Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int size = 20;
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(100));
        }
        System.out.println("Заданный список: " + list);
        System.out.println("Результирующий список: " + getResultList(list));
    }
    public static ArrayList<Integer> getResultList(ArrayList<Integer> list) {
        ArrayList<Integer> resList = new ArrayList<>();
        for (int item : list) {
            if ((item % 2) != 0) {
                resList.add(item);
            }
        }
        return resList;
    }
}

