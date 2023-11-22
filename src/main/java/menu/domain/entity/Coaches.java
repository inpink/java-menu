package menu.domain.entity;

import static menu.constants.IntegerConstants.MAX_COACHES_COUNT;
import static menu.constants.IntegerConstants.MIN_COACHES_COUNT;

import java.util.List;
import menu.util.ExceptionUtil;
import menu.util.ListUtil;

public class Coaches {

    private final List<Coach> coaches;

    private Coaches(final List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
    }

    public static Coaches create(final List<Coach> coaches) {
        return new Coaches(coaches);
    }

    private void validate(final List<Coach> coaches) {
        validateSize(coaches);
    }

    private void validateSize(final List<Coach> coaches) {
        if (!ListUtil.isSizeInRange(
                coaches,
                MIN_COACHES_COUNT.getValue(),
                MAX_COACHES_COUNT.getValue())) {
            ExceptionUtil.throwInvalidValueException();
        }
    }

    public List<Coach> getCoaches() {
        return coaches;
    }
}
