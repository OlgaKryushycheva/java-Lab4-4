package com.example.chef;

/**
 * Відображає стан свіжості овоча під час додавання до салату.
 */
public enum Freshness {
    FRESH("Свіжий"),
    WILTING("Підв'ялений"),
    COOKED("Приготований");

    private final String displayName;

    Freshness(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
