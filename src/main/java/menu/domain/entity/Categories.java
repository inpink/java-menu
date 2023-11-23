package menu.domain.entity;

import static menu.constants.IntegerConstants.MAX_DUPLICATE_CATEGORY_COUNT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.entity.category.Category;

public class Categories {
    private final Map<RecommendDay, Category> categories;

    private Categories(Map<RecommendDay, Category> categories) {
        this.categories = categories;
    }

    public static Categories createRandomCategories(List<RecommendDay> days) {
        List<Category> availableCategories = decideCategories(days.size());
        Map<RecommendDay, Category> categoryMap = new HashMap<>();

        for (int i = 0; i < days.size(); i++) {
            RecommendDay day = days.get(i);
            Category category = availableCategories.get(i);
            categoryMap.put(day, category);
        }

        return new Categories(categoryMap);
    }

    public static List<Category> decideCategories(int count) {
        List<Category> categories = new ArrayList<>();
        Map<Category, Integer> categoryCount = new HashMap<>();

        for (int i = 0; i < count; i++) {
            Category category;
            do {
                category = Category.pickRandomCategory();
            } while (categoryCount.getOrDefault(category, 0)
                    >= MAX_DUPLICATE_CATEGORY_COUNT.getValue());
            System.out.println(category.getName());
            categories.add(category);
            categoryCount.put(category, categoryCount.getOrDefault(category, 0) + 1);
        }

        return categories;
    }

    public Map<RecommendDay, Category> getCategories() {
        return categories;
    }

    public List<RecommendDay> getDays() {
        return new ArrayList<>(categories.keySet());
    }

    public Category getCategory(RecommendDay recommendDay) {
        return categories.get(recommendDay);
    }

    public List<Category> getSortedCategories() {
        List<RecommendDay> sortedDays = Arrays.stream(RecommendDay.values())
                .sorted(Comparator.comparingInt(RecommendDay::getIndex))
                .collect(Collectors.toList());

        List<Category> sortedCategories = sortedDays.stream()
                .map(day -> categories.get(day))
                .collect(Collectors.toList());

        return sortedCategories;
    }

}
