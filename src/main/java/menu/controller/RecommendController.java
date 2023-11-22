package menu.controller;

import static menu.messages.ErrorMessages.INVALID_COACH_NAME;
import static menu.messages.ErrorMessages.INVALID_MENU_ITEME;

import menu.domain.dto.CoachRestrctionsDto;
import menu.domain.dto.CoachesNamesDto;
import menu.util.InputUtil;
import menu.view.InputView;
import menu.view.OutputView;
import menu.view.StartView;

public class RecommendController {

    private final StartView startView;
    private final InputView inputView;
    private final OutputView outputView;

    public RecommendController(final StartView startView,
                               final InputView inputView,
                               final OutputView outputView) {
        this.startView = startView;
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void play() {
        printStartMessage();

        final CoachesNamesDto coachesNamesDto = InputUtil.retryOnInvalidInput(
                this::inputCoachesnames,
                e -> outputView.printErrorMessage(INVALID_COACH_NAME.getMessage())
        );

        final CoachRestrctionsDto coachRestrctionsDto = InputUtil.retryOnInvalidInput(
                this::inputCoachRestrctions,
                e -> outputView.printErrorMessage(INVALID_MENU_ITEME.getMessage())
        );

    }

    private void printStartMessage() {
        startView.printStartMenuRecommendMessage();
    }

    private CoachesNamesDto inputCoachesnames() {
        return inputView.inputCoachesNames();
    }

    private CoachRestrctionsDto inputCoachRestrctions() {
        return inputView.inputCoachMenuRestrictions();
    }

}
