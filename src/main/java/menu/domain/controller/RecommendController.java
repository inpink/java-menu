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
        inputView.startMessage();
        Categories categories = createCategories();

        CoachesNamesDto coachesNamesDto = inputValidCoachesNames();

        Coaches coaches = inputValidRecommend(coachesNamesDto, categories);

        Recommend recommend = new Recommend(categories, coaches);
        recommend.getCoaches().getCoaches().stream().forEach(
                a -> System.out.println(a.getRecommendItems().getItems().get(1)));

        outputRecommendResult(recommend);
    }

    private Coaches inputValidRecommend(CoachesNamesDto coachesNamesDto, Categories categories) {
        return InputUtil.retryOnInvalidInput(()
                        -> assignRecommendItemsToCoaches(coachesNamesDto, categories),
                errorMessage -> outputView.displayError("[ERROR] 1"));
    }

    private CoachesNamesDto inputValidCoachesNames() {
        return InputUtil.retryOnInvalidInput(this::inputCoachesNames,
                errorMessage -> outputView.displayError("[ERROR] 2"));
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

    private Coaches assignRecommendItemsToCoaches(CoachesNamesDto coachesNamesDto,
                                                  Categories categories) {
        Coaches coaches = createCoaches(coachesNamesDto);

        for (Coach coach : coaches.getCoaches()) {
            CoachNameDto coachNameDto = CoachMapper.ofName(coach);
            CoachRestrictionsDto coachRestrictionsDto = inputView.inputCoachRestrictions(coachNameDto);
            coach.addRestrictions(coachRestrictionsDto);
        }
        return coaches;
    }

    private void outputRecommendResult(Recommend recommend) {
        RecommendDto recommendDto = RecommendMapper.ofResult(recommend);
        outputView.outputRecommendResult(recommendDto);
    }


}
