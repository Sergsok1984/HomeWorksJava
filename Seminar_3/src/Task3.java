//Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int size = 10;
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(rnd.nextInt(100));
            sum += list.get(i);
        }
        System.out.println("Заданный список: " + list);
        Collections.sort(list);
        System.out.println("Максимальное значение: " + list.get(size - 1));
        System.out.println("Минимальное значение: " + list.get(0));
        System.out.println("Среднее значение: " + (double) sum / size);
    }
}
