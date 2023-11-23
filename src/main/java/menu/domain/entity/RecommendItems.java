package menu.domain.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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

    public List<CategoryItem> getItems() {
        return new ArrayList<>(items.values());
    }

    public List<String> getSortedItems() {
        return items.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getKey().getIndex()))
                .map(Map.Entry::getValue)
                .map(CategoryItem::getName)
                .collect(Collectors.toList());
    }
}
