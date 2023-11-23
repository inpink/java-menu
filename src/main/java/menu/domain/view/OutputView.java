package menu.domain.view;

import static menu.domain.messages.OutputMessages.RECOMMEND_RESULT_CATEGORY;
import static menu.domain.messages.OutputMessages.RECOMMEND_RESULT_SORT;
import static menu.domain.messages.OutputMessages.RECOMMEND_RESULT_START;

import java.util.List;
import java.util.Map;
import menu.domain.dto.RecommendDto;

public class OutputView {

    public void outputRecommendResult(RecommendDto recommendDto) {
        List<String> sorts = recommendDto.getSorts();
        List<String> categories = recommendDto.getCategories();
        Map<String, List<String>> coachesItems = recommendDto.getCoachesItems();

        outputRecommendationStartMessage();
        outputSortInformation(sorts);
        outputCategoryInformation(categories);
        outputCoachesItemsInformation(coachesItems);
    }

    private void outputRecommendationStartMessage() {
        System.out.println(RECOMMEND_RESULT_START.getMessage());
    }

    private void outputSortInformation(List<String> sorts) {
        System.out.println(RECOMMEND_RESULT_SORT.getMessage());
    }

    private void outputCategoryInformation(List<String> categories) {
        System.out.println(RECOMMEND_RESULT_CATEGORY.getMessage());
    }

    private void outputCoachesItemsInformation(Map<String, List<String>> coachesItems) {

    }


}
