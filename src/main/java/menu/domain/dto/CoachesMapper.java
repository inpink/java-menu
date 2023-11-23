package menu.domain.dto;

import static menu.domain.messages.InputMessages.INPUT_SEPARATOR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.util.StringUtil;

public class CoachesMapper {
    public static CoachesNamesDto convertToNames(String input) {
        String deleteSpaces = StringUtil.removeAllSpaces(input);

        List<String> names = Arrays.stream(deleteSpaces.split(
                        INPUT_SEPARATOR.getMessage()))
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());

        return new CoachesNamesDto(names);
    }
}
