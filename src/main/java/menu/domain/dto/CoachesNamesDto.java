package menu.domain.dto;

import java.util.Collections;
import java.util.List;

public final class CoachesNamesDto {
    private final List<String> names;

    public CoachesNamesDto(List<String> names) {
        this.names = Collections.unmodifiableList(names);
    }

    public List<String> getNames() {
        return names;
    }
}
