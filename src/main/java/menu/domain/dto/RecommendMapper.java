package menu.domain.dto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.entity.Categories;
import menu.domain.entity.Coach;
import menu.domain.entity.Coaches;
import menu.domain.entity.Recommend;
import menu.domain.entity.RecommendDay;
import menu.domain.entity.RecommendItems;
import menu.domain.entity.category.Category;
import menu.domain.entity.category.CategoryItem;

public class RecommendMapper {

    public static RecommendDto ofResult(Recommend recommend) {
        List<String> sorts = recommend.getSorts()
                .stream()
                .map(RecommendDay::toString)
                .collect(Collectors.toList());
        List<String> categories = extractCategoryNames(recommend.getCategories());
        Map<String, List<String>> coachesItems = extractCoachesItems(recommend.getCoaches());

        return new RecommendDto(sorts, categories, coachesItems);
    }

    private static List<String> extractCategoryNames(Categories categories) {
        return categories.getCategories().values()
                .stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }

    private static Map<String, List<String>> extractCoachesItems(Coaches coaches) {
        return coaches.getCoaches().stream()
                .collect(Collectors.toMap(
                        Coach::getName,
                        coach -> coach.getRecommendItems().getItems().stream()
                                .map(CategoryItem::getName)
                                .collect(Collectors.toList())
                ));
    }
}
