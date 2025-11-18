package com.example.chef;

import java.util.Objects;

/**
 * Base class for any vegetable that can be placed into a salad.
 */
public abstract class Vegetable {
    private final String name;
    private final double caloriesPer100g;
    private final double weightInGrams;
    private final Freshness freshness;

    protected Vegetable(String name, double caloriesPer100g, double weightInGrams, Freshness freshness) {
        this.name = Objects.requireNonNull(name, "name");
        this.caloriesPer100g = caloriesPer100g;
        this.weightInGrams = weightInGrams;
        this.freshness = Objects.requireNonNull(freshness, "freshness");
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
     * Calculates calories contributed by this vegetable in the salad.
     *
     * @return total calories for this ingredient instance
     */
    public double getTotalCalories() {
        return (caloriesPer100g * weightInGrams) / 100.0;
    }

    /**
     * Short description including class-specific details.
     */
    public abstract String getDescription();

    @Override
    public String toString() {
        return String.format("%s [%s], %.1f kcal/100g, weight %.1fg, freshness %s", getDescription(),
                name, caloriesPer100g, weightInGrams, freshness);
    }
}
