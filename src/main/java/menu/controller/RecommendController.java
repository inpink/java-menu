package menu.controller;

import static menu.messages.ErrorMessages.INVALID_COACH_NAME;
import static menu.messages.ErrorMessages.INVALID_MENU_ITEME;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.domain.dto.CoachRestrctionsDto;
import menu.domain.dto.CoachesNamesDto;
import menu.domain.entity.Coach;
import menu.domain.entity.Coaches;
import menu.domain.entity.Restrictions;
import menu.domain.menuItem.Menu;
import menu.domain.menuItem.MenuItem;
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

        CoachesNamesDto coachesNamesDto = inputValidCoachesNames();

        final Set<String> receiveCoachesNames = coachesNamesDto.getCoachesNames();

        List<Coach> generatedCoaches = new ArrayList<>();

        for (String coachName : receiveCoachesNames) {
            CoachRestrctionsDto coachRestrctionsDto = inputCoachRestrctions();
            Set<String> receiveCoachRestrictions = coachRestrctionsDto.getCoachRestrctions();
            Set<MenuItem> restrictionItems= new HashSet<>();
            for (String coachRestriction : receiveCoachRestrictions) {
                final MenuItem menuItem = Menu.findItem(coachRestriction);
                restrictionItems.add(menuItem);
            }

            Restrictions restrictions = Restrictions.create(restrictionItems);

            Coach coach = Coach.create(coachName, restrictions);

            generatedCoaches.add(coach);
        }

        final Coaches coachGroup = Coaches.create(generatedCoaches);


    }

    private void printStartMessage() {
        startView.printStartMenuRecommendMessage();
    }

    private CoachesNamesDto inputValidCoachesNames() {
        return InputUtil.retryOnInvalidInput(
                this::inputCoachesNames,
                e -> outputView.printErrorMessage(INVALID_COACH_NAME.getMessage())
        );
    }

    private CoachRestrctionsDto inputValidCoachRestrctions() {
        return InputUtil.retryOnInvalidInput(
                this::inputCoachRestrctions,
                e -> outputView.printErrorMessage(INVALID_MENU_ITEME.getMessage())
        );

    }

    private CoachesNamesDto inputCoachesNames() {
        return inputView.inputCoachesNames();
    }

    private CoachRestrctionsDto inputCoachRestrctions() {
        return inputView.inputCoachMenuRestrictions();
    }

}
