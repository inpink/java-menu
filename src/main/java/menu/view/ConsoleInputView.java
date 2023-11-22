package menu.view;


import static menu.messages.InputMessages.INPUT_COACHES_NAMES;
import static menu.messages.InputMessages.INPUT_COACH_MENU_RESTRICTIONS;
import static menu.messages.InputMessages.SEPERATE_STANDARD;

import menu.domain.dto.CoachMapper;
import menu.domain.dto.CoachNameDto;
import menu.domain.dto.CoachRestrctionsDto;
import menu.domain.dto.CoachesMapper;
import menu.domain.dto.CoachesNamesDto;
import menu.util.InputUtil;
import menu.util.OutputUtil;

public class ConsoleInputView implements InputView {

    @Override
    public CoachesNamesDto inputCoachesNames() {
        System.out.println(INPUT_COACHES_NAMES.getMessage());
        final String input = InputUtil.input();
        OutputUtil.printEmptyLine();

        return CoachesMapper.convertToNames(input, SEPERATE_STANDARD.getMessage());
    }

    @Override
    public CoachRestrctionsDto inputCoachMenuRestrictions(final CoachNameDto coachNameDto) {
        System.out.println(coachNameDto.getCoachName() + INPUT_COACH_MENU_RESTRICTIONS.getMessage());
        final String input = InputUtil.input();
        OutputUtil.printEmptyLine();

        return CoachMapper.convertToRestrictions(input, SEPERATE_STANDARD.getMessage());
    }
}
