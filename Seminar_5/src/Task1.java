//Реализуйте структуру телефонной книги с помощью HashMap,
//учитывая, что 1 человек может иметь несколько телефонов.

import java.util.HashMap;
import java.util.List;

public class Task1 {
    public static HashMap<String, List<String>> phoneBook = new HashMap<>();

    public static void main(String[] args) {
        getPhoneBook();
        getPhone("Федоров");
    }

    public static void getPhoneBook() {
        phoneBook.put("Николаев", List.of("8989111111", "8989222222"));
        phoneBook.put("Федоров", List.of("8989333333", "8989444444"));
        phoneBook.put("Круглова", List.of("8989555555", "8989666666"));
        phoneBook.put("Смирнова", List.of("8989777777", "8989888888"));
    }

    public static void getPhone(String name) {
        System.out.printf("%s: %s", name, String.join(", ", phoneBook.get(name)));
    }
}


