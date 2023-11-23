package menu.domain.view;

import static menu.domain.messages.InputMessages.START;

import menu.domain.util.OutputUtil;

public class InputView {
    public void startMessage() {
        System.out.println(START.getMessage());
        OutputUtil.printEmptyLine();
    }
}
