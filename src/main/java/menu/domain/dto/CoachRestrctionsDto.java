package menu.domain.dto;

import java.util.Set;

public class CoachRestrctionsDto {
    private final Set<String> coachRestrctions;

    public CoachRestrctionsDto(final Set<String> coachRestrctions) {
        this.coachRestrctions = coachRestrctions;
    }

    public Set<String> getCoachRestrctions() {
        return coachRestrctions;
    }
}
