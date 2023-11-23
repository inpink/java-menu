package menu.domain.entity;

import java.util.List;
import menu.domain.entity.category.Category;

public class Recommend {
    private final Categories categories;
    private final Coaches coaches;

    public Recommend(Categories categories, Coaches coaches) {
        this.categories = categories;
        this.coaches = coaches;
        assignRecommendations();
    }

    private void assignRecommendations() {
        categories.getCategories()
                .forEach(this::assignRecommendationForDay);
    }

    private void assignRecommendationForDay(RecommendDay recommendDay,
                                            Category category) {
        coaches.getCoaches()
                .forEach(coach
                        -> assignRecommendationToCoach(coach, recommendDay, category));
    }

    private void assignRecommendationToCoach(Coach coach,
                                             RecommendDay recommendDay,
                                             Category category) {
        coach.addRecommendItem(recommendDay, category);
    }

    public Categories getCategories() {
        return categories;
    }

    public Coaches getCoaches() {
        return coaches;
    }

    public List<RecommendDay> getSorts() {
        return categories.getDays();
    }
}
