package com.example.chef;

/**
 * Коренеплід (наприклад, морква або буряк).
 */
public class RootVegetable extends Vegetable {
    private final double rootLengthInCm;

    public RootVegetable(String name, double caloriesPer100g, double weightInGrams, Freshness freshness,
                         double rootLengthInCm) {
        super(name, caloriesPer100g, weightInGrams, freshness);
        this.rootLengthInCm = rootLengthInCm;
    }

    public double getRootLengthInCm() {
        return rootLengthInCm;
    }

    @Override
    public String getDescription() {
        return String.format("Коренеплід (%.1f см)", rootLengthInCm);
    }
}
