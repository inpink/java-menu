package menu.domain.menuItem;

public interface MenuItem {

    String getName();

    default boolean isSameName(String name) {
        return getName().equalsIgnoreCase(name);
    }
}
