package menu.domain.dto;

import static menu.domain.messages.InputMessages.INPUT_SEPARATOR;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import menu.domain.util.StringUtil;

public class CoachMapper {
    public static CoachRestrictionsDto convertToRestrictions(String input) {
        String deleteSpaces = StringUtil.removeAllSpaces(input);

        Set<String> restrictions = Arrays.stream(deleteSpaces.split(
                        INPUT_SEPARATOR.getMessage()))
                .filter(restriction -> !restriction.isEmpty())
                .collect(Collectors.toSet());

        return new CoachRestrictionsDto(restrictions);
    }

    public static CoachNameDto ofName(String name) {
        return new CoachNameDto(name);
    }
}
