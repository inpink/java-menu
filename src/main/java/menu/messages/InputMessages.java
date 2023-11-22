package menu.messages;

public enum InputMessages {

    SEPERATE_STANDARD(","),
    INPUT_COACHES_NAMES(String.format("코치의 이름을 입력해 주세요. (%d 로 구분)", SEPERATE_STANDARD)),
    INPUT_COACH_MENU_RESTRICTIONS("(이)가 못 먹는 메뉴를 입력해 주세요.");

    private final String message;

    InputMessages(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
