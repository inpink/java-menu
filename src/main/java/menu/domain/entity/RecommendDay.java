package menu.domain.entity;

public enum RecommendDay {
    MONDAY("월요일",1),
    TUESDAY("화요일",2),
    WEDNESDAY("수요일",3),
    THURSDAY("목요일",4),
    FRIDAY("금요일",5);

    private final String koreanName;
    private final int index;

    RecommendDay(String koreanName, int index) {
        this.koreanName = koreanName;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getKoreanName() {
        return koreanName;
    }

}
