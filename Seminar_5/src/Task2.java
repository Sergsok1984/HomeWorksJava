//Пусть дан список сотрудников:
//Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

import java.util.*;

public class Task2 {

       public static void main(String[] args) {
        List<String> employees = List.of("Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов",
                "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников",
                "Петр Петин", "Иван Ежов");
        getSortMap(getMap(employees));
    }

    public static Map<String, Integer> getMap(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String item : list) {
            String[] nameList = item.split(" ");
            for (int i = 0; i < nameList.length; i += 2) {
                if (map.containsKey(nameList[i])) {
                    map.replace(nameList[i], map.get(nameList[i]) + 1);
                } else {
                    map.put(nameList[i], 1);
                }
            }
        }
        return map;
    }

    public static void getSortMap(Map<String, Integer> map) {
        Map<String, Integer> sortMap = new LinkedHashMap<>();
        int max = 1;
        for (int value : map.values()) {
            if (value > max) {
                max = value;
            }
        }
        for (int i = max; i > 0; i--) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (map.get(entry.getKey()) == i) {
                    sortMap.put(entry.getKey(), map.get(entry.getKey()));
                }
            }
        }
        for (Map.Entry<String, Integer> entry : sortMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}








