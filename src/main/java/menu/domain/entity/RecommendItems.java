package menu.domain.entity;

import java.util.HashMap;
import java.util.Map;
import menu.domain.entity.category.CategoryItem;

public class RecommendItems {
    private final Map<RecommendDay, CategoryItem> items;

    private RecommendItems() {
        this.items= new HashMap<>();
    }
    private RecommendItems(Map<RecommendDay, CategoryItem> items) {
        this.items = items;
    }

    public static RecommendItems createEmpty() {
        return new RecommendItems();
    }

    public boolean containsItem(CategoryItem item) {
        return items.containsValue(item);
    }

    public void addItem(RecommendDay recommendDay, CategoryItem randomItem) {
        items.put(recommendDay,randomItem);
    }


}
