package menu.domain.entity;

import static menu.constants.IntegerConstants.MAX_DUPLICATE_CATEGORY_COUNT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import menu.domain.entity.category.Category;

public class Categories {
    private final Map<RecommendDay, Category> categories;

    private Categories(Map<RecommendDay, Category> categories) {
        this.categories = categories;
    }

    public static Categories createRandomCategories(List<RecommendDay> days) {
        Map<RecommendDay, Category> categoryMap = days.stream()
                .collect(Collectors.toMap(
                        day -> day,
                        day -> Category.pickRandomCategory()));

        return new Categories(categoryMap);
    }

    public static List<Category> decideCategories() {
        Map<Category, Long> categoryCount = new HashMap<>();

        return Stream.generate(Category::pickRandomCategory)
                .filter(category
                        -> categoryCount.getOrDefault(category, 0L)
                        < MAX_DUPLICATE_CATEGORY_COUNT.getValue())
                .peek(category
                        -> categoryCount.merge(category, 1L, Long::sum))
                .collect(Collectors.toList());
    }

    public Map<RecommendDay, Category> getCategories() {
        return categories;
    }
}
