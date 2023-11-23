package menu.domain.entity;

public class Coach {
    private final String name;
    private final Restrictions restrictions;
    private final RecommendItems recommendItems;

    private Coach(String name, Restrictions restrictions, RecommendItems recommendItems) {
        this.name = name;
        this.restrictions = restrictions;
        this.recommendItems = recommendItems;
    }

    public static Coach create(String name) {
        return new Coach(name,
                Restrictions.createEmpty(),
                RecommendItems.createEmpty());
    }

    public String getName() {
        return name;
    }

    public Restrictions getRestrictions() {
        return restrictions;
    }

    public RecommendItems getRecommendItems() {
        return recommendItems;
    }
}
