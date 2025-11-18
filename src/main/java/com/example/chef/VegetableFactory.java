package com.example.chef;

/**
 * Creates vegetables based on the type string loaded from configuration.
 */
public final class VegetableFactory {
    private VegetableFactory() {
    }

    public static Vegetable create(String type, String name, double caloriesPer100g, double weightInGrams,
                                   Freshness freshness, double extraParameter) {
        return switch (type.toLowerCase()) {
            case "leafy" -> new LeafyVegetable(name, caloriesPer100g, weightInGrams, freshness,
                    (int) Math.round(extraParameter));
            case "root" -> new RootVegetable(name, caloriesPer100g, weightInGrams, freshness, extraParameter);
            case "fruit" -> new FruitVegetable(name, caloriesPer100g, weightInGrams, freshness,
                    (int) Math.round(extraParameter));
            default -> throw new IllegalArgumentException("Unsupported vegetable type: " + type);
        };
    }
}
