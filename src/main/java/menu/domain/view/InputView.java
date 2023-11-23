package menu.domain.view;

import static menu.domain.messages.InputMessages.INPUT_COACHES_NAMES;
import static menu.domain.messages.InputMessages.START;

import menu.domain.dto.CoachesMapper;
import menu.domain.dto.CoachesNamesDto;
import menu.domain.util.InputUtil;
import menu.domain.util.OutputUtil;

public class InputView {
    public void startMessage() {
        System.out.println(START.getMessage());
        OutputUtil.printEmptyLine();
    }

    public CoachesNamesDto inputCoachesNames() {
        System.out.println(INPUT_COACHES_NAMES.getMessage());
        String input = InputUtil.input();

        OutputUtil.printEmptyLine();

        return CoachesMapper.convertToNames(input);
    }
}
