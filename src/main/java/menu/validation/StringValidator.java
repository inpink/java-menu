package menu.validation;

import menu.util.ExceptionUtil;

public final class StringValidator {

    public static void validateNotNull(final String value) {
        if (value == null) {
            ExceptionUtil.throwInvalidValueException();
        }
    }
}
