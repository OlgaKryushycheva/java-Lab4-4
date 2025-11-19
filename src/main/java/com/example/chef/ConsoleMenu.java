package com.example.chef;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Проста консольна взаємодія з обраним салатом.
 */
public class ConsoleMenu {
    private final Salad salad;
    private final Scanner scanner;

    public ConsoleMenu(Salad salad, Scanner scanner) {
        this.salad = salad;
        this.scanner = scanner;
    }

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Ваш вибір: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1" -> showIngredients();
                case "2" -> showCalories();
                case "3" -> sortIngredients();
                case "4" -> findByCaloriesPer100g();
                case "5" -> findByWeight();
                case "0" -> running = false;
                default -> System.out.println("Невідомий пункт меню, спробуйте знову.\n");
            }
        }
        System.out.println("Дякуємо за використання застосунку Шеф-кухар!");
    }

    private void printMenu() {
        System.out.println("=== Меню салату \"" + salad.getName() + "\" ===");
        System.out.println("1. Показати інгредієнти");
        System.out.println("2. Підрахувати калорійність");
        System.out.println("3. Відсортувати інгредієнти за калорійністю на 100 г");
        System.out.println("4. Знайти інгредієнти у діапазоні калорійності на 100 г");
        System.out.println("5. Знайти інгредієнти у діапазоні ваги");
        System.out.println("0. Вихід");
    }

    private void showIngredients() {
        System.out.printf("Салат складається з %.1f г продуктів.\n", salad.getTotalWeight());
        salad.getIngredients().forEach(ingredient -> System.out.println(" - " + ingredient));
        System.out.println();
    }

    private void showCalories() {
        System.out.printf(Locale.ROOT, "Загальна калорійність: %.2f ккал.\n\n", salad.getTotalCalories());
    }

    private void sortIngredients() {
        salad.sortBy(Comparator.comparingDouble(Vegetable::getCaloriesPer100g));
        System.out.println("Відсортовано за калорійністю на 100 г (зростанням). Склад салату тепер: ");
        salad.getIngredients().forEach(ingredient -> System.out.println(" - " + ingredient));
        System.out.println();
    }

    private void findByCaloriesPer100g() {
        double min = askForDouble("Мінімум (ккал на 100 г): ");
        double max = askForDouble("Максимум (ккал на 100 г): ");
        List<Vegetable> found = salad.findByCaloriesPer100gRange(min, max);
        printFound(found);
    }

    private void findByWeight() {
        double min = askForDouble("Мінімальна вага (г): ");
        double max = askForDouble("Максимальна вага (г): ");
        List<Vegetable> found = salad.findByWeightRange(min, max);
        printFound(found);
    }

    private void printFound(List<Vegetable> vegetables) {
        if (vegetables.isEmpty()) {
            System.out.println("Нічого не знайдено.\n");
            return;
        }
        System.out.println("Знайдено інгредієнти:");
        vegetables.forEach(ingredient -> System.out.println(" - " + ingredient));
        System.out.println();
    }

    private double askForDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Будь ласка, введіть число.");
            }
        }
    }
}
