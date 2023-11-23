package menu.domain.entity.category;

public enum Korean implements CategoryItem {
    GIMBAP("김밥"),
    KIMCHI_STEW("김치찌개"),
    SSAMBAP("쌈밥"),
    DOENJANG_STEW("된장찌개"),
    BIBIMBAP("비빔밥"),
    KALGUKSU("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    JAEYUK_BOKKEUM("제육볶음");

    private final String koreanName;

    Korean(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }

    @Override
    public String getName() {
        return koreanName;
    }
}
