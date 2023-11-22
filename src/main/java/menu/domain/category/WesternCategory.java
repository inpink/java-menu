package menu.domain.category;

public enum WesternCategory implements CategoryItem {

    LASAGNA("라자냐"),
    GRATIN("그라탱"),
    GNOCCHI("뇨끼"),
    QUICHE("끼슈"),
    FRENCH_TOAST("프렌치 토스트"),
    BAGUETTE("바게트"),
    SPAGHETTI("스파게티"),
    PIZZA("피자"),
    PANINI("파니니");

    private final String name;

    WesternCategory(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
