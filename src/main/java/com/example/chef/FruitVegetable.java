package com.example.chef;

/**
 * Овочі з плодами (помідор, огірок тощо).
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
        return String.format("Плід (%d насінин)", seedCount);
    }
}
