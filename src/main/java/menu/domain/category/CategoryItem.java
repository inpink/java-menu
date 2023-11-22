package menu.domain.category;

public interface CategoryItem {

    String getName();

    default boolean isSameName(String name) {
        return getName().equalsIgnoreCase(name);
    }
}
