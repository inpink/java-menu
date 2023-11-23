package menu.domain.dto;

import java.util.List;
import java.util.Map;

public class RecommendDto {
    private final List<String> sorts;
    private final List<String> categories;
    private final Map<String, List<String>> coachesItems;

    public RecommendDto(List<String> sorts,
                        List<String> categories,
                        Map<String, List<String>> coachesItems) {
        this.sorts = sorts;
        this.categories = categories;
        this.coachesItems = coachesItems;
    }

    public List<String> getSorts() {
        return sorts;
    }

    public List<String> getCategories() {
        return categories;
    }

    public Map<String, List<String>> getCoachesItems() {
        return coachesItems;
    }
}
