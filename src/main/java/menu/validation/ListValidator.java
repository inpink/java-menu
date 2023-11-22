package menu.validation;

import java.util.List;
import menu.util.ExceptionUtil;

public class ListValidator {

    public static <T> void validateNotNull(final List<T> list) {
        if (list == null) {
            ExceptionUtil.throwInvalidValueException();
        }
    }
}
