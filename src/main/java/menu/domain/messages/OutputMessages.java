package menu.domain.messages;

public enum OutputMessages {
    RECOMMEND_RESULT_START("메뉴 추천 결과입니다."),
    RECOMMEND_RESULT_SORT("구분"),
    RECOMMEND_RESULT_CATEGORY("카테고리");

    private final String message;

    OutputMessages(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
