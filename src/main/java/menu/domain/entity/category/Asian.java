package menu.domain.entity.category;

public enum Asian implements CategoryItem {
    PAD_THAI("팟타이"),
    KHAO_PAD("카오 팟"),
    NASI_GORENG("나시고렝"),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥"),
    RICE_NOODLE("쌀국수"),
    TOM_YUM_GOONG("똠얌꿍"),
    BANH_MI("반미"),
    SPRING_ROLL("월남쌈"),
    BUN_CHA("분짜");

    private final String koreanName;

    Asian(String koreanName) {
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
