package bg.tu.varna.recyclerview;

import java.util.ArrayList;

public class Fruits {
    private String name;
    private int calories;

    public Fruits() {
    }

    public Fruits(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public static ArrayList<Fruits> getData() {
        ArrayList<Fruits> fruitsList = new ArrayList<Fruits>();
        String[] fruits = {"banana", "strawberry", "apple", "cherry", "orange"};
        int[] calories = {20, 18, 32, 14, 40};

        for (int i = 0; i < fruits.length; i++) {
            Fruits fruit = new Fruits();
            fruit.setName(fruits[i]);
            fruit.setCalories(calories[i]);

            fruitsList.add(fruit);
        }

        return fruitsList;
    }
}
