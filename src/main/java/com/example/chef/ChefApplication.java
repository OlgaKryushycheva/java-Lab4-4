package com.example.chef;

import java.util.List;
import java.util.Scanner;

/**
 * Точка входу до консольної програми «Шеф-кухар».
 */
public final class ChefApplication {
    private ChefApplication() {
    }

    public static void main(String[] args) {
        VegetableRepository repository = new VegetableRepository();
        List<Vegetable> vegetables = repository.loadFromResource("data/vegetables.csv");

        Salad salad = new Salad("Вітамінний мікс", vegetables);
        try (Scanner scanner = new Scanner(System.in)) {
            ConsoleMenu menu = new ConsoleMenu(salad, scanner);
            menu.run();
        }
    }
}
