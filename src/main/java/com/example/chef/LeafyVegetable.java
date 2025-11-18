package com.example.chef;

/**
 * Leafy vegetables such as spinach or lettuce.
 */
public class LeafyVegetable extends Vegetable {
    private final int leafCount;

    public LeafyVegetable(String name, double caloriesPer100g, double weightInGrams, Freshness freshness, int leafCount) {
        super(name, caloriesPer100g, weightInGrams, freshness);
        this.leafCount = leafCount;
    }

    public int getLeafCount() {
        return leafCount;
    }

    @Override
    public String getDescription() {
        return String.format("Leafy (%d leaves)", leafCount);
    }
}
