package menu.domain.dto;

import java.util.Set;

public class CoachNameDto {
    private final String coachName;

    public CoachNameDto(final String coachName) {
        this.coachName = coachName;
    }

    public String getCoachName() {
        return coachName;
    }
}
