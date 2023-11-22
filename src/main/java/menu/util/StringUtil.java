package menu.util;

import menu.validation.StringValidator;

public final class StringUtil {

    public static String removeAllSpaces(final String input) {
        return input.replace(" ", "");
    }

    public static boolean isLengthInRange(final String name, final int min, final int max) {
        return isLengthAtLeast(name, min) && isLengthAtMost(name, max);
    }

    public static boolean isLengthAtLeast(final String value, final int min) {
        StringValidator.validateNotNull(value);
        return value.length() >= min;
    }

    public static boolean isLengthAtMost(final String value, final int max) {
        StringValidator.validateNotNull(value);
        return value.length() <= max;
    }

}
