package menu.domain.entity;

import java.util.Set;
import menu.domain.category.CategoryItem;

public class Restrictions {
    private final Set<CategoryItem> items;

    private Restrictions(final Set<CategoryItem> items) {
        this.items = items;
    }

    public static Restrictions create(final Set<CategoryItem> items) {
        return new Restrictions(items);
    }



}
