package menu.domain.view;

import static menu.domain.messages.InputMessages.INPUT_COACHES_NAMES;
import static menu.domain.messages.InputMessages.INPUT_RESTRICTIONS;
import static menu.domain.messages.InputMessages.START;

import menu.domain.dto.CoachMapper;
import menu.domain.dto.CoachNameDto;
import menu.domain.dto.CoachRestrictionsDto;
import menu.domain.dto.CoachesMapper;
import menu.domain.dto.CoachesNamesDto;
import menu.domain.util.InputUtil;
import menu.domain.util.OutputUtil;

public class InputView {
    public void startMessage() {
        System.out.println(START.getMessage());
    }

    public CoachesNamesDto inputCoachesNames() {
        System.out.println(INPUT_COACHES_NAMES.getMessage());
        String input = InputUtil.input();

        return CoachesMapper.convertToNames(input);
    }

    public CoachRestrictionsDto inputCoachRestrictions(CoachNameDto coachNameDto) {
        String coachName = coachNameDto.getName();
        System.out.println(coachName + INPUT_RESTRICTIONS.getMessage());
        String input = InputUtil.input();


        return CoachMapper.convertToRestrictions(input);
    }
}
