package menu.util;

import java.util.List;
import menu.validation.ListValidator;

public class ListUtil {

    public static <T> boolean isSizeInRange(final List<T> list, final int min, final int max) {
        return isSizeAtLeast(list, min) && isSizeAtMost(list, max);
    }

    public static <T> boolean isSizeAtLeast(final List<T> list, final int min) {
        ListValidator.validateNotNull(list);
        return list.size() >= min;
    }

    public static <T> boolean isSizeAtMost(final List<T> list, final int max) {
        ListValidator.validateNotNull(list);
        return list.size() <= max;
    }

}
