package com.example.chef;

import java.util.Locale;
import java.util.Objects;

/**
 * Базовий клас для будь-якого овоча, який можна додати до салату.
 */
public abstract class Vegetable {
    private final String name;
    private final double caloriesPer100g;
    private final double weightInGrams;
    private final Freshness freshness;

    protected Vegetable(String name, double caloriesPer100g, double weightInGrams, Freshness freshness) {
        this.name = Objects.requireNonNull(name, "назва");
        this.caloriesPer100g = caloriesPer100g;
        this.weightInGrams = weightInGrams;
        this.freshness = Objects.requireNonNull(freshness, "свіжість");
    }

    public String getName() {
        return name;
    }

    public double getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public double getWeightInGrams() {
        return weightInGrams;
    }

    public Freshness getFreshness() {
        return freshness;
    }

    /**
     * Обчислює кількість калорій, яку додає овоч у салаті.
     *
     * @return сумарна калорійність цього інгредієнта
     */
    public double getTotalCalories() {
        return (caloriesPer100g * weightInGrams) / 100.0;
    }

    /**
     * Короткий опис із клас-специфічними деталями.
     */
    public abstract String getDescription();

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "%s [%s], %.1f ккал/100 г, вага %.1f г, свіжість: %s", getDescription(),
                name, caloriesPer100g, weightInGrams, freshness);
    }
}
