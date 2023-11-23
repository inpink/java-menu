package menu.domain.view;

import static menu.domain.messages.OutputMessages.RECOMMEND_RESULT_CATEGORY;
import static menu.domain.messages.OutputMessages.RECOMMEND_RESULT_END;
import static menu.domain.messages.OutputMessages.RECOMMEND_RESULT_SORT;
import static menu.domain.messages.OutputMessages.RECOMMEND_RESULT_START;

import java.util.List;
import java.util.Map;
import menu.domain.dto.RecommendDto;
import menu.domain.util.OutputUtil;

public class OutputView {

    public void outputRecommendResult(RecommendDto recommendDto) {
        List<String> sorts = recommendDto.getSorts();
        List<String> categories = recommendDto.getCategories();
        Map<String, List<String>> coachesItems = recommendDto.getCoachesItems();

        outputRecommendationStartMessage();
        outputSortInformation(sorts);
        outputCategoryInformation(categories);
        outputCoachesItemsInformation(coachesItems);
        outputRecommendationEndMessage();
    }

    private void outputRecommendationStartMessage() {
        System.out.println(RECOMMEND_RESULT_START.getMessage());
    }

    private void outputSortInformation(List<String> sorts) {
        System.out.println(formatWithBrackets(
                RECOMMEND_RESULT_SORT.getMessage(),
                sorts));
    }

    private void outputCategoryInformation(List<String> categories) {
        System.out.println(formatWithBrackets(
                RECOMMEND_RESULT_CATEGORY.getMessage(),
                categories));
    }

    private void outputCoachesItemsInformation(Map<String, List<String>> coachesItems) {
        coachesItems.forEach((coachName, items) -> {
            System.out.println(formatWithBrackets(coachName, items));
        });
    }

    private void outputRecommendationEndMessage() {
        OutputUtil.printEmptyLine();
        System.out.println(RECOMMEND_RESULT_END.getMessage());
    }

    public String formatWithBrackets(String label, List<String> items) {
        String formattedItems = String.join(" | ", items);
        return "[ " + label + " | " + formattedItems + " ]";
    }

    public void displayError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
