package menu.domain.controller;

import java.util.List;
import menu.domain.dto.CoachMapper;
import menu.domain.dto.CoachNameDto;
import menu.domain.dto.CoachRestrictionsDto;
import menu.domain.dto.CoachesNamesDto;
import menu.domain.dto.RecommendDto;
import menu.domain.dto.RecommendMapper;
import menu.domain.entity.Categories;
import menu.domain.entity.Coach;
import menu.domain.entity.Coaches;
import menu.domain.entity.Recommend;
import menu.domain.entity.RecommendDay;
import menu.domain.util.InputUtil;
import menu.domain.view.InputView;
import menu.domain.view.OutputView;

public class RecommendController {

    private final InputView inputView;
    private final OutputView outputView;

    public RecommendController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        CoachesNamesDto coachesNamesDto = inputValidCoachesNames();
        Coaches coaches = createCoaches(coachesNamesDto);
        Categories categories = createCategories();

        assignRecommendItemsToCoaches(coaches, categories);
        Recommend recommend = new Recommend(categories, coaches);
        outputRecommendResult(recommend);
    }

    private CoachesNamesDto inputValidCoachesNames() {
        return InputUtil.retryOnInvalidInput(inputView::inputCoachesNames,
                this::handleInputError);
    }

    private void handleInputError(String errorMessage) {
        outputView.displayError(errorMessage);
    }

    private CoachesNamesDto inputCoachesNames() {
        return inputView.inputCoachesNames();
    }

    private Coaches createCoaches(CoachesNamesDto coachesNamesDto) {
        return Coaches.create(coachesNamesDto);
    }

    private Categories createCategories() {
        return Categories.createRandomCategories(List.of(RecommendDay.values()));
    }

    private void assignRecommendItemsToCoaches(Coaches coaches, Categories categories) {
        for (Coach coach : coaches.getCoaches()) {
            CoachNameDto coachNameDto = CoachMapper.ofName(coach);
            CoachRestrictionsDto coachRestrictionsDto = inputView.inputCoachRestrictions(coachNameDto);
            addRecommendItems(coach, categories);
            coach.addRestrictions(coachRestrictionsDto);
        }
    }

    private void addRecommendItems(Coach coach, Categories categories) {
        List<RecommendDay> days = List.of(RecommendDay.values());
        for (RecommendDay day : days) {
            coach.addRecommendItem(day, categories.getCategory(day));
        }
    }

    private void outputRecommendResult(Recommend recommend) {
        RecommendDto recommendDto = RecommendMapper.ofResult(recommend);
        outputView.outputRecommendResult(recommendDto);
    }
}
