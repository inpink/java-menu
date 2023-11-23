package menu.domain.entity.category;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Category {
    JAPANESE("일식", Japanese.values()),
    KOREAN("한식", Korean.values()),
    CHINESE("중식", Chinese.values()),
    ASIAN("아시안", Asian.values()),
    WESTERN("양식", Western.values());

    private final String categoryName;
    private final List<CategoryItem> dishes;

    Category(String categoryName, CategoryItem[] dishes) {
        this.categoryName = categoryName;
        this.dishes = Arrays.stream(dishes)
                .collect(Collectors.toList());
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<CategoryItem> getDishes() {
        return dishes;
    }
}
