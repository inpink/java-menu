package menu.domain.category;

public enum KoreanCategory implements CategoryItem {

    KIMBAP("김밥"),
    KIMCHI_STEW("김치찌개"),
    SSAMBAP("쌈밥"),
    DOENJANG_STEW("된장찌개"),
    BIBIMBAP("비빔밥"),
    KALGUKSU("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    JAEYOOK_BOKEUM("제육볶음");

    private final String name;

    KoreanCategory(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
