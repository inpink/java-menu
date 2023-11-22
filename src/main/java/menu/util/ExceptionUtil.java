package menu.util;

public final class ExceptionUtil {

    public static void throwInvalidValueException() {

        throw new IllegalArgumentException();
    }

    public static IllegalArgumentException returnInvalidValueException() {

       return new IllegalArgumentException();
    }
}
