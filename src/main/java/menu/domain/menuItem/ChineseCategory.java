package menu.domain.menuItem;

public enum ChineseCategory implements MenuItem {

    KANPOONGI("깐풍기"),
    FRIED_NOODLES("볶음면"),
    DONGPO_PORK("동파육"),
    JJAJANGMYEON("짜장면"),
    JJAMPONG("짬뽕"),
    MAPO_TOFU("마파두부"),
    SWEET_AND_SOUR_PORK("탕수육"),
    TOMATO_EGG_STIR_FRY("토마토 달걀볶음"),
    PEPPER_STIR_FRY("고추잡채");

    private final String name;

    ChineseCategory(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
