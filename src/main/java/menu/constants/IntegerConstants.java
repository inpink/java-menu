package menu.constants;

public enum IntegerConstants {

    MIN_NAME_LEN(2),
    MAX_NAME_LEN(4),
    MIN_COACHES_COUNT(2),
    MAX_COACHES_COUNT(5),
    MAX_DUPLICATE_CATEGORY_COUNT(2);

    private final int value;

    IntegerConstants(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(getValue());
    }
}
