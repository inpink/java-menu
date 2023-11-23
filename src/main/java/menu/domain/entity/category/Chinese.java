package menu.domain.entity.category;

public enum Chinese implements CategoryItem {
    KAMPUNGI("깐풍기"),
    STIR_FRIED_NOODLES("볶음면"),
    DONGPO_PORK("동파육"),
    JAJANGMYEON("짜장면"),
    JJAMPPONG("짬뽕"),
    MAPA_TOFU("마파두부"),
    SWEET_AND_SOUR_PORK("탕수육"),
    TOMATO_EGG_STIR_FRY("토마토 달걀볶음"),
    PEPPER_JAPCHAE("고추잡채");

    private final String koreanName;

    Chinese(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }
}
