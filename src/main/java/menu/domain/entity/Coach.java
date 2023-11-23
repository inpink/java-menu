package menu.domain.entity;

import static menu.constants.IntegerConstants.MAX_NAME_LEN;
import static menu.constants.IntegerConstants.MIN_NAME_LEN;

import menu.domain.util.ExceptionUtil;

public class Coach {
    private final String name;
    private final Restrictions restrictions;
    private final RecommendItems recommendItems;

    private Coach(String name, Restrictions restrictions, RecommendItems recommendItems) {
        validateName(name);
        this.name = name;
        this.restrictions = restrictions;
        this.recommendItems = recommendItems;
    }


    public static Coach create(String name) {
        return new Coach(name,
                Restrictions.createEmpty(),
                RecommendItems.createEmpty());
    }

    private void validateName(String name) {
        validateNameLengthInRange(name);
    }

    private void validateNameLengthInRange(String name) {
        if (name.length() < MIN_NAME_LEN.getValue()
                || name.length() > MAX_NAME_LEN.getValue()) {
            ExceptionUtil.throwInvalidValueException();
        }
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
