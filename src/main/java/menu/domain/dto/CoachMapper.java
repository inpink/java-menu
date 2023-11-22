package menu.domain.dto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import menu.util.StringUtil;

public class CoachMapper {
    public static CoachRestrctionsDto convertToRestrictions(final String input, final String separator) {
        final String deleteSpaces = StringUtil.removeAllSpaces(input);
        final Set<String> coachesNames = Arrays.stream(deleteSpaces.split(separator))
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toSet());

        return new CoachRestrctionsDto(coachesNames);
    }

    public static CoachNameDto of(final String coachName) {
        return new CoachNameDto(coachName);
    }
}
