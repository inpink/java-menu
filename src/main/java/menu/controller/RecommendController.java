package menu.controller;

import static menu.messages.ErrorMessages.INVALID_COACH_NAME;
import static menu.messages.ErrorMessages.INVALID_MENU_ITEME;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import menu.domain.dto.CoachMapper;
import menu.domain.dto.CoachNameDto;
import menu.domain.dto.CoachRestrctionsDto;
import menu.domain.dto.CoachesNamesDto;
import menu.domain.entity.Coach;
import menu.domain.entity.Coaches;
import menu.service.CoachService;
import menu.util.InputUtil;
import menu.view.InputView;
import menu.view.OutputView;
import menu.view.StartView;

public class RecommendController {

    private final StartView startView;
    private final InputView inputView;
    private final OutputView outputView;
    private final CoachService coachService;

    public RecommendController(final StartView startView,
                               final InputView inputView,
                               final OutputView outputView, CoachService coachService) {
        this.startView = startView;
        this.inputView = inputView;
        this.outputView = outputView;
        this.coachService = coachService;
    }


    public void play() {
        CoachesNamesDto coachesNamesDto = inputValidCoachesNames();
        List<Coach> coaches = createCoaches(coachesNamesDto.getCoachesNames());
        Coaches.create(coaches);
        menuService
    }

    private CoachesNamesDto inputValidCoachesNames() {
        return InputUtil.retryOnInvalidInput(
                this::inputCoachesNames,
                e -> outputView.printErrorMessage(INVALID_COACH_NAME.getMessage())
        );
    }


    private List<Coach> createCoaches(Set<String> coachNames) {
        return coachNames.stream()
                .map(this::createValidCoach)
                .collect(Collectors.toList());
    }

    private Coach createValidCoach(String coachName) {
        return InputUtil.retryOnInvalidInput(
                () -> attemptCreatingCoach(coachName),
                e -> outputView.printErrorMessage(e.getMessage())
        );
    }

    private Coach attemptCreatingCoach(String coachName) {
        CoachNameDto coachNameDto = CoachMapper.of(coachName);
        CoachRestrctionsDto coachRestrctionsDto = inputValidCoachRestrctions(coachNameDto);
        return coachService.createCoach(coachNameDto, coachRestrctionsDto);
    }

    private CoachRestrctionsDto inputValidCoachRestrctions(CoachNameDto coachNameDto) {
        return InputUtil.retryOnInvalidInput(
                () -> inputCoachRestrctions(coachNameDto),
                e -> outputView.printErrorMessage(INVALID_MENU_ITEME.getMessage())
        );
    }

    private CoachesNamesDto inputCoachesNames() {
        return inputView.inputCoachesNames();
    }

    private CoachRestrctionsDto inputCoachRestrctions(CoachNameDto coachNameDto) {
        return inputView.inputCoachMenuRestrictions(coachNameDto);
    }

}
