package menu;

import menu.domain.controller.RecommendController;
import menu.domain.entity.category.Category;
import menu.domain.view.InputView;
import menu.domain.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RecommendController recommendController = new RecommendController(
                new InputView(),
                new OutputView()
        );

        recommendController.play();
    }
}
