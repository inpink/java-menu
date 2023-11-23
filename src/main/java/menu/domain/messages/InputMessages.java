package menu.domain.messages;

public enum InputMessages {
    START("점심 메뉴 추천을 시작합니다."),
    INPUT_COACHES_NAMES("코치의 이름을 입력해 주세요. (, 로 구분)"),
    INPUT_RESTRICTIONS("(이)가 못 먹는 메뉴를 입력해 주세요.");

    private final String message;

    InputMessages(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
