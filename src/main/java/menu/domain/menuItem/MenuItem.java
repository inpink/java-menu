package menu.domain.menuItem;

public interface MenuItem {

    String getName();

    default boolean hasItem(String name) {
        return getName().equalsIgnoreCase(name);
    }

}
