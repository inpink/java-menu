package menu.domain.entity;

import static menu.constants.IntegerConstants.MAX_COACH_NAME_LENGTH;
import static menu.constants.IntegerConstants.MIN_COACH_NAME_LENGTH;

import menu.util.ExceptionUtil;
import menu.util.StringUtil;

public class Coach {

    private final String name;

    private Coach(final String name) {
        validate(name);
        this.name = name;
    }

    public static Coach create(final String name) {
        return new Coach(name);
    }


    private void validate(final String name) {
        validateLength(name);
    }

    private void validateLength(final String name) {
        if (!StringUtil.isLengthInRange(
                name,
                MIN_COACH_NAME_LENGTH.getValue(),
                MAX_COACH_NAME_LENGTH.getValue())) {
            ExceptionUtil.throwInvalidValueException();
        }
    }

    public String getName() {
        return name;
    }
}
