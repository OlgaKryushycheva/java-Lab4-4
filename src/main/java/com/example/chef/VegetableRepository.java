package com.example.chef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Loads vegetables from a CSV resource that describes a salad recipe.
 */
public class VegetableRepository {

    /**
     * Reads vegetables from a resource placed on the classpath.
     *
     * @param resourcePath path relative to the classpath root, e.g. {@code data/vegetables.csv}
     * @return list of vegetables described in the file
     */
    public List<Vegetable> loadFromResource(String resourcePath) {
        InputStream stream = VegetableRepository.class.getClassLoader().getResourceAsStream(resourcePath);
        if (stream == null) {
            throw new IllegalStateException("Resource not found: " + resourcePath);
        }

        List<Vegetable> vegetables = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#") || line.toLowerCase(Locale.ROOT).startsWith("type")) {
                    continue;
                }
                String[] tokens = line.split(",");
                if (tokens.length < 6) {
                    continue;
                }

                String type = tokens[0].trim();
                String name = tokens[1].trim();
                double caloriesPer100g = Double.parseDouble(tokens[2].trim());
                double weight = Double.parseDouble(tokens[3].trim());
                Freshness freshness = Freshness.valueOf(tokens[4].trim().toUpperCase(Locale.ROOT));
                double extra = Double.parseDouble(tokens[5].trim());

                vegetables.add(VegetableFactory.create(type, name, caloriesPer100g, weight, freshness, extra));
            }
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read resource: " + resourcePath, e);
        }
        return vegetables;
    }
}
