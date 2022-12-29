/**Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
 “Введите цифру, соответствующую необходимому критерию:
 1 - ОЗУ
 2 - Объем ЖД
 3 - Операционная система
 4 - Цвет …
 Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
 Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static HashSet<Laptop> laptopHashSet = new HashSet<>();


    public static void main(String[] args) {

        laptopHashSet.add(new Laptop("Asus1", 500, 8, "Windows", "black"));
        laptopHashSet.add(new Laptop("Acer1", 500, 4, "Windows", "black"));
        laptopHashSet.add(new Laptop("Asus2", 750, 16, "Linux", "black"));
        laptopHashSet.add(new Laptop("Asus3", 1000, 16, "Windows", "white"));
        laptopHashSet.add(new Laptop("Acer2", 500, 4, "Windows", "white"));
        laptopHashSet.add(new Laptop("HP1", 750, 8, "Windows", "black"));
        laptopHashSet.add(new Laptop("Lenovo1", 500, 8, "Windows", "white"));
        laptopHashSet.add(new Laptop("Apple1", 750, 16, "macOS", "white"));
        laptopHashSet.add(new Laptop("Samsung1", 1000, 8, "Linux", "black"));
        menu();
    }

    public static Set<Laptop> filter(Set<Laptop> laptop) {
        Set<Laptop> listLaptop = new HashSet<>(laptop);
        System.out.print("""
                Введите номера критериев фильтрации ноутбуков:
                1. Объем жесткого диска
                2. Объем оперативной памяти
                3. Операционная система
                4. Цвет
                Ваш выбор:\s""");
        String userRequest = scan.next();
        for (int i = 0; i < userRequest.length(); i++) {
            if (1 == Character.getNumericValue(userRequest.charAt(i))) {
                System.out.print("""
                        Выберите объем жёсткого диска:
                        1 - 500 Гб
                        2 - 750 Гб
                        3 - 1000 Гб
                        Ваш выбор:\s""");
                int choiceHD = scan.nextInt();
                for (Laptop tempLaptop : laptop) {
                    if (choiceHD == 1) {
                        if (tempLaptop.getHardDisk() != 500) {
                            listLaptop.remove(tempLaptop);
                        }
                    }
                    if (choiceHD == 2) {
                        if (tempLaptop.getHardDisk() != 750) {
                            listLaptop.remove(tempLaptop);
                        }
                    }
                    if (choiceHD == 3) {
                        if (tempLaptop.getHardDisk() != 1000) {
                            listLaptop.remove(tempLaptop);
                        }
                    }
                }
            }

            if (2 == Character.getNumericValue(userRequest.charAt(i))) {
                System.out.print("""
                        Выберите объем оперативной памяти :
                        1 - 4 Гб
                        2 - 8 Гб
                        3 - 16 Гб
                        Ваш выбор:\s""");
                int choiceRAM = scan.nextInt();
                for (Laptop tempLaptop : laptop) {
                    if (choiceRAM == 1) {
                        if (tempLaptop.getOperativeMemory() != 4) {
                            listLaptop.remove(tempLaptop);
                        }
                    }
                    if (choiceRAM == 2) {
                        if (tempLaptop.getOperativeMemory() != 8) {
                            listLaptop.remove(tempLaptop);
                        }
                    }
                    if (choiceRAM == 3) {
                        if (tempLaptop.getOperativeMemory() != 16) {
                            listLaptop.remove(tempLaptop);
                        }
                    }
                }
            }

            if (3 == Character.getNumericValue(userRequest.charAt(i))) {
                System.out.print("""
                        Укажите операционную систему:
                        1 - Linux
                        2 - macOS
                        3 - Windows
                        Ваш выбор:\s""");
                int choiceOS = scan.nextInt();
                for (Laptop tempLaptop : laptop) {
                    if (choiceOS == 1) {
                        if ((!"Linux".equals(tempLaptop.getOperatingSystem()))) {
                            listLaptop.remove(tempLaptop);
                        }
                    }
                    if (choiceOS == 2) {
                        if ((!"macOS".equals(tempLaptop.getOperatingSystem()))) {
                            listLaptop.remove(tempLaptop);
                        }
                    }
                    if (choiceOS == 3) {
                        if ((!"Windows".equals(tempLaptop.getOperatingSystem()))) {
                            listLaptop.remove(tempLaptop);
                        }
                    }
                }
            }

            if (4 == Character.getNumericValue(userRequest.charAt(i))) {
                System.out.print("""
                        Укажите цвет ноутбука:
                        1 - black
                        2 - white
                        Ваш выбор:\s""");
                int choiceCol = scan.nextInt();
                for (Laptop tempLaptop : laptop) {
                    if (choiceCol == 1) {
                        if ((!"black".equals(tempLaptop.getColor()))) {
                            listLaptop.remove(tempLaptop);
                        }
                    }
                    if (choiceCol == 2) {
                        if ((!"white".equals(tempLaptop.getColor()))) {
                            listLaptop.remove(tempLaptop);
                        }
                    }
                }
            }
        }
        if (listLaptop.isEmpty()) {
            System.out.println("Ноутбуков с указанными критериями нет");
        } return listLaptop;
    }


    public static void menu() {
        while (true) {
            System.out.print("""
                    Выберите действие:
                    1. Список всех ноутбуков
                    2. Выбор ноутбука
                    0. Выход
                    Ваш выбор:\s""");
            int op = scan.nextInt();
            if (op == 0) {
                System.out.println("Программа завершена!");
                break;
            } else if (op == 1) {
                System.out.println(laptopHashSet.toString().replaceAll("\\[|\\]|,", ""));
            } else if (op == 2) {
                System.out.println(filter(laptopHashSet).toString().replaceAll("\\[|\\]|,", ""));
            } else System.out.println("Некорректная операция.");
        }
    }
}
