package menu.domain.entity;

import static menu.constants.IntegerConstants.MAX_NAME_LEN;
import static menu.constants.IntegerConstants.MIN_NAME_LEN;

import java.util.stream.Stream;
import menu.domain.dto.CoachRestrictionsDto;
import menu.domain.entity.category.Category;
import menu.domain.entity.category.CategoryItem;
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

    public void addRecommendItem(RecommendDay recommendDay, Category category) {
        System.out.println("recommendDay = " + recommendDay);
        System.out.println("category = " + category);
        CategoryItem item = category.pickRandomItem();
        boolean isValid = isValidItem(item);

        while (!isValid) {
            item = category.pickRandomItem();
            isValid = isValidItem(item);
        }

        recommendItems.addItem(recommendDay, item);
    }

    private boolean isValidItem(CategoryItem item) {
        return !restrictions.containsItem(item) && !recommendItems.containsItem(item);
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

    public void addRestrictions(CoachRestrictionsDto coachRestrictionsDto) {
        coachRestrictionsDto.getRestrictions().stream()
                .forEach(itemName -> restrictions.add(itemName));
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
