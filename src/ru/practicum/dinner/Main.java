package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;
    static ArrayList<String> dishTypes = new ArrayList<>();

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Неверная команда. Пожалуйста, выберите 1, 2 или 3.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addNewDish(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem;
        do {
            nextItem = scanner.nextLine();
            if (!nextItem.isEmpty()) {
                if (dc.menu.containsKey(nextItem)) {
                    dishTypes.add(nextItem);
                } else {
                    System.out.println("Такого типа блюд еще нет. Пожалуйста, выберите другой тип.");
                }
            }
        } while (!nextItem.isEmpty());

        ArrayList<ArrayList<String>> combos = dc.generateDishCombo(dishTypes, numberOfCombos);
        for (int i = 0; i < combos.size(); i++) {
            System.out.println("Комбо " + (i + 1) + ": " + "\n" + combos.get(i));
        }
    }
}
