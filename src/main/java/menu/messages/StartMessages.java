package menu.messages;

public enum StartMessages {
    START_MENU_RECOMMEND("점심 메뉴 추천을 시작합니다.");

    private final String message;

    StartMessages(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
