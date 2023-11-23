package menu.domain.entity;

import java.util.HashSet;
import java.util.Set;
import menu.domain.entity.category.Category;
import menu.domain.entity.category.CategoryItem;
import menu.domain.util.ExceptionUtil;

public class Restrictions {
    private final Set<CategoryItem> restrictions;

    private Restrictions() {
        this.restrictions = new HashSet<>();
    }
    private Restrictions(Set<CategoryItem> restrictions) {
        this.restrictions = restrictions;
    }

    public static Restrictions createEmpty() {
        return new Restrictions();
    }

    public void add(String itemName) {
        if (!Category.hasItem(itemName)){
            ExceptionUtil.throwInvalidValueException();
        }

        CategoryItem item = Category.findItem(itemName);
        restrictions.add(item);
    }
}
