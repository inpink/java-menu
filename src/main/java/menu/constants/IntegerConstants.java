package menu.constants;

public enum IntegerConstants {

    MIN_COACH_NAME_LENGTH(2),
    MAX_COACH_NAME_LENGTH(4),
    MIN_COACHES_COUNT(2),
    MAX_COACHES_COUNT(5);

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
