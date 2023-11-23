package menu.domain.entity.category;

public enum Western  implements CategoryItem{
    LASAGNA("라자냐"),
    GRATIN("그라탱"),
    GNOCCHI("뇨끼"),
    QUICHE("끼슈"),
    FRENCH_TOAST("프렌치 토스트"),
    BAGUETTE("바게트"),
    SPAGHETTI("스파게티"),
    PIZZA("피자"),
    PANINI("파니니");

    private final String koreanName;

    Western(String koreanName) {
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
