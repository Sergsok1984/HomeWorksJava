//Реализуйте структуру телефонной книги с помощью HashMap,
//учитывая, что 1 человек может иметь несколько телефонов.

import java.io.*;
import java.util.*;

public class Task1 {
    private static final HashMap<String, List<String>> phoneBook = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    static String name;
    static String phone;


    public static void main(String[] args) throws IOException {
        System.out.print("Телефонный справочник. \n");
        menu();

    }

    public static void menu() throws IOException {
        while (true) {
            System.out.print("""                    
                    Выберите действие:
                    1 - Добавить новый контакт.
                    2 - Добавить новый номер контакту.
                    3 - Удалить контакт.
                    4 - Удалить номер контакта.
                    5 - Найти контакт по имени.
                    6 - Найти контакт по номеру.
                    7 - Список контактов.
                    8 - Импортировать справочник.
                    9 - Сохранить справочник.
                    0 - Выход.
                    Ваш выбор:\s""");
            int op = scanner.nextInt();
            if (op == 0) {
                System.out.println("Программа завершена!");
                break;
            } else {
                switch (op) {
                    case 1 -> addContact();
                    case 2 -> addPhoneNumber();
                    case 3 -> delContact();
                    case 4 -> delPhoneNumber();
                    case 5 -> phoneByName();
                    case 6 -> nameByPhone();
                    case 7 -> printPhoneBook();
                    case 8 -> importPhoneBook();
                    case 9 -> savePhoneBook();
                    default -> System.out.println("Некорректная операция.");
                }
            }
        }
    }

    public static void addContact() {
        getName();
        if (phoneBook.containsKey(name)) {
            System.out.println("Контакт с таким именем уже есть!");

        } else {
            getPhone();
            List<String> phoneNumber = new ArrayList<>();
            phoneNumber.add(phone);
            phoneBook.put(name, phoneNumber);
        }
    }

    public static void addPhoneNumber() {
        getName();
        if (phoneBook.containsKey(name)) {
            getPhone();
            phoneBook.get(name).add(phone);
        } else {
            System.out.println("Контакта с таким именем нет!");

        }
    }

    public static void delContact() {
        getName();
        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
        } else {
            System.out.println("Контакта с таким именем нет");
        }
    }

    public static void delPhoneNumber() {
        getName();
        if (phoneBook.containsKey(name)) {
            getPhone();
            phoneBook.get(name).removeIf(e -> e.equals(phone));
        } else {
            System.out.println("Такого номера нет");
        }
    }

    public static void phoneByName() {
        getName();
        if (phoneBook.containsKey(name)) {
            System.out.printf("%s: %s", name, String.join(", ", phoneBook.get(name)));
            System.out.println();
        } else {
            System.out.println("Контакта с таким именем нет");
        }
    }

    public static void nameByPhone() {
        getPhone();
        for (String k : phoneBook.keySet()) {
            if (phoneBook.get(k).contains(phone)) {
                System.out.printf("%s: %s", k, String.join(", ", phoneBook.get(k)));
            } else {
                System.out.println("Контакта с таким номером нет!");
            }
        }
    }


    public static void printPhoneBook() {
        if (!phoneBook.isEmpty()) {
            System.out.println("Список контактов: ");
            for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
                System.out.println(entry.getKey() + ": " + String.join(", ", entry.getValue()));
            }
        } else System.out.println("Справочник пустой!");
    }

    public static void getName() {
        System.out.print("Введите имя: ");
        name = scanner.next();
    }

    public static void getPhone() {
        System.out.print("Введите номер телефона: ");
        phone = scanner.next();
    }

    public static void savePhoneBook() throws IOException {
        FileWriter fw = new FileWriter("src/phoneBook.txt");
        fw.write(String.valueOf(phoneBook).replaceAll("[\"{},\\s+]", " "));
        fw.close();
    }

    public static void importPhoneBook() throws IOException {
        File file = new File("src/phoneBook.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("=");
                List<String> phoneNumber;
                String name = data[0];
                phoneNumber = Collections.singletonList(data[1]);
                phoneBook.put(name, phoneNumber);
            }
        }

        System.out.println(phoneBook);
    }
}








