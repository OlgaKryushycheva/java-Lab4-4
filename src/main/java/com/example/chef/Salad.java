package com.example.chef;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Модель салату, що складається з різних овочів.
 */
public class Salad {
    private final String name;
    private final List<Vegetable> ingredients;

    public Salad(String name, List<Vegetable> ingredients) {
        this.name = name;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getName() {
        return name;
    }

    public List<Vegetable> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }

    public double getTotalCalories() {
        return ingredients.stream().mapToDouble(Vegetable::getTotalCalories).sum();
    }

    public double getTotalWeight() {
        return ingredients.stream().mapToDouble(Vegetable::getWeightInGrams).sum();
    }

    public void sortBy(Comparator<Vegetable> comparator) {
        ingredients.sort(comparator);
    }

    public List<Vegetable> findByCaloriesPer100gRange(double min, double max) {
        return ingredients.stream()
                .filter(v -> v.getCaloriesPer100g() >= min && v.getCaloriesPer100g() <= max)
                .collect(Collectors.toList());
    }

    public List<Vegetable> findByWeightRange(double min, double max) {
        return ingredients.stream()
                .filter(v -> v.getWeightInGrams() >= min && v.getWeightInGrams() <= max)
                .collect(Collectors.toList());
    }
}
