package menu.domain.util;

public final class ExceptionUtil {

    public static void throwInvalidValueException() {

        throw new IllegalArgumentException();
    }

    public static IllegalArgumentException returnInvalidValueException() {

        return new IllegalArgumentException();
    }

    public static IllegalArgumentException returnInvalidValueException(
            final String message) {

        return new IllegalArgumentException(message);
    }

}
