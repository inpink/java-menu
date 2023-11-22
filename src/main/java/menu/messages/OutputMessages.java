package menu.messages;


public enum OutputMessages {
    MENU_RECOMMEND_RESULT("메뉴 추천 결과입니다."),
    MENU_RECOMMEND_COMPLETE("추천을 완료했습니다.");

    private final String message;

    OutputMessages(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
