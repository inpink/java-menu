package menu.messages;

public enum ErrorMessages {

    INVALID_COACH_NAME("올바르지 않은 코치 이름입니다. 다시 입력해 주세요."),
    INVALID_MENU_ITEME("올바르지 않은 메뉴 아이템입니다. 다시 입력해 주세요.");


    private final String message;
    private static final String prefix = "[ERROR] ";

    ErrorMessages(final String message) {
        this.message = prefix + message;
    }

    public String getMessage() {
        return message;
    }
}
