package menu.domain.dto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class CoachRestrictionsDto {
    private final Set<String> restrictions;

    public CoachRestrictionsDto(Set<String> restrictions) {
        this.restrictions = Collections.unmodifiableSet(new HashSet<>(restrictions));
    }

    public Set<String> getRestrictions() {
        return restrictions;
    }
}
