package menu.domain.entity;

import java.util.Set;
import menu.domain.menuItem.MenuItem;

public class Restrictions {
    private final Set<MenuItem> items;

    private Restrictions(final Set<MenuItem> items) {
        this.items = items;
    }

    public static Restrictions create(final Set<MenuItem> items) {
        return new Restrictions(items);
    }



}
