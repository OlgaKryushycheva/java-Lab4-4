package com.example.chef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Завантажує овочі з CSV-ресурсу, що описує рецепт салату.
 */
public class VegetableRepository {

    /**
     * Зчитує овочі з ресурсу, розташованого у classpath.
     *
     * @param resourcePath шлях відносно кореня classpath, наприклад {@code data/vegetables.csv}
     * @return список овочів, описаних у файлі
     */
    public List<Vegetable> loadFromResource(String resourcePath) {
        InputStream stream = resolveResourceStream(resourcePath);

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
            throw new IllegalStateException("Не вдалося прочитати ресурс: " + resourcePath, e);
        }
        return vegetables;
    }

    private InputStream resolveResourceStream(String resourcePath) {
        InputStream stream = VegetableRepository.class.getClassLoader().getResourceAsStream(resourcePath);
        if (stream != null) {
            return stream;
        }

        Path path = Paths.get(resourcePath);
        if (Files.exists(path)) {
            try {
                return Files.newInputStream(path);
            } catch (IOException e) {
                throw new IllegalStateException("Не вдалося відкрити файл ресурсу: " + path, e);
            }
        }

        Path sourceResource = Paths.get("src", "main", "resources").resolve(resourcePath);
        if (Files.exists(sourceResource)) {
            try {
                return Files.newInputStream(sourceResource);
            } catch (IOException e) {
                throw new IllegalStateException("Не вдалося відкрити файл ресурсу: " + sourceResource, e);
            }
        }

        throw new IllegalStateException(
                "Ресурс не знайдено: " + resourcePath +
                        ". Переконайтеся, що він доступний у classpath або за шляхами ./" + resourcePath +
                        " чи ./src/main/resources/" + resourcePath
        );
    }
}
