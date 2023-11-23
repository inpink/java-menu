package menu.domain.entity;

import static menu.constants.IntegerConstants.MAX_COACHES_COUNT;
import static menu.constants.IntegerConstants.MIN_COACHES_COUNT;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import menu.domain.dto.CoachesNamesDto;
import menu.domain.util.ExceptionUtil;

public class Coaches {
    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        validate(coaches);
        this.coaches = coaches;
    }

    public static Coaches create(CoachesNamesDto coachesNamesDto) {
        List<Coach> coaches = coachesNamesDto.getNames()
                .stream()
                .map(Coach::create)
                .collect(Collectors.toList());

        return new Coaches(coaches);
    }



    private void validate(List<Coach> coaches) {
        validateDuplicate(coaches);
        validateCoachesCount(coaches);
    }

    private void validateDuplicate(List<Coach> coaches) {
        Set<String> uniqueNames = coaches.stream()
                .map(Coach::getName)
                .collect(Collectors.toSet());

        if (uniqueNames.size() != coaches.size()) {
            ExceptionUtil.throwInvalidValueException();
        }
    }

    private void validateCoachesCount(List<Coach> coaches) {
        if (coaches.size() < MIN_COACHES_COUNT.getValue()
                || coaches.size() > MAX_COACHES_COUNT.getValue()) {
            ExceptionUtil.throwInvalidValueException();
        }
    }

}
