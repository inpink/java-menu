package menu.domain.entity.category;

public enum Japanese implements CategoryItem {
    GYUDON("규동"),
    UDON("우동"),
    MISOSHIRU("미소시루"),
    SUSHI("스시"),
    KATSUDON("가츠동"),
    ONIGIRI("오니기리"),
    HAYASHIRICE("하이라이스"),
    RAMEN("라멘"),
    OKONOMIYAKI("오코노미야끼");

    private final String koreanName;

    Japanese(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }

}
