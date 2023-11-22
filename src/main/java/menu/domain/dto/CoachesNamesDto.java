package menu.domain.dto;

import java.util.Set;

public class CoachesNamesDto { // TODO: 실제 미션에서는 record 사용(자바 버전문제로 적용 못함)

    private final Set<String> coachesNames;

    public CoachesNamesDto(final Set<String> coachesNames) {
        this.coachesNames = coachesNames;
    }

    public Set<String> getCoachesNames() {
        return coachesNames;
    }
}
