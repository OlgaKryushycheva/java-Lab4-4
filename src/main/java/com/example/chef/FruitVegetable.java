package com.example.chef;

/**
 * Vegetables that are technically fruits like tomatoes or cucumbers.
 */
public class FruitVegetable extends Vegetable {
    private final int seedCount;

    public FruitVegetable(String name, double caloriesPer100g, double weightInGrams, Freshness freshness,
                          int seedCount) {
        super(name, caloriesPer100g, weightInGrams, freshness);
        this.seedCount = seedCount;
    }

    public int getSeedCount() {
        return seedCount;
    }

    @Override
    public String getDescription() {
        return String.format("Fruit (%d seeds)", seedCount);
    }
}
