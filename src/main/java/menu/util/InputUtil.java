package menu.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class InputUtil {

    public static String input() {
        return Console.readLine();
    }

    public static <T> T retryOnInvalidInput(final Supplier<T> inputSupplier,
                                            final Consumer<IllegalArgumentException> exceptionHandler) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                exceptionHandler.accept(e);
            }
        }
    }

}
