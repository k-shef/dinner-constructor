package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    public HashMap<String, ArrayList<String>> menu;
    Random random;

    public DinnerConstructor() {
        menu = new HashMap<>();
        random = new Random();
    }

    public void addNewDish(String dishType, String dishName) {
        if (!menu.containsKey(dishType)) {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            menu.put(dishType, dishes);
        } else {
            ArrayList<String> dishes = menu.get(dishType);
            if (!dishes.contains(dishName)) {
                dishes.add(dishName);
            } else {
                System.out.println("Такое блюдо уже добавлено в список.");
            }
        }
    }

    public ArrayList<ArrayList<String>> generateDishCombo(ArrayList<String> dishTypes, int numberOfCombos) {
        ArrayList<ArrayList<String>> generatedCombos = new ArrayList<>();

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String dishType : dishTypes) {
                ArrayList<String> dishesOfType = menu.get(dishType);
                if (dishesOfType != null && !dishesOfType.isEmpty()) {
                    int randomDishIndex = random.nextInt(dishesOfType.size());
                    combo.add(dishesOfType.get(randomDishIndex));
                }
            }
            generatedCombos.add(new ArrayList<>(combo));
        }

        return generatedCombos;
    }
}
