package menu.domain.dto;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import menu.util.StringUtil;

public class CoachesMapper {
    public static CoachesNamesDto convertToNames(final String input, final String separator) {
        final String deleteSpaces = StringUtil.removeAllSpaces(input);
        final Set<String> coachesNames = Arrays.stream(deleteSpaces.split(separator))
                .collect(Collectors.toSet());

        return new CoachesNamesDto(coachesNames);
    }
}
