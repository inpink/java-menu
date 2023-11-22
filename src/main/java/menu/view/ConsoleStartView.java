package menu.view;

import static menu.messages.StartMessages.START_MENU_RECOMMEND;

import menu.util.OutputUtil;

public class ConsoleStartView implements StartView {

    @Override
    public void printStartMenuRecommendMessage() {
        System.out.println(START_MENU_RECOMMEND.getMessage());
        OutputUtil.printEmptyLine();
    }
}
